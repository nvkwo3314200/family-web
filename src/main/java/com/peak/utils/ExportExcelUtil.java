package com.peak.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * 此文件已经通过测试 OK， 需要poi-3.7-20101029.jar 等日志Jar包
 **/
public class ExportExcelUtil {

	private static Logger logger = Logger.getLogger(ExportExcelUtil.class);

	private HSSFWorkbook workbook = null;
	@SuppressWarnings("unused")
	private HSSFSheet sheet = null;

	public HSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}

	public HSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(HSSFSheet sheet) {
		this.sheet = sheet;
	}

	public ExportExcelUtil(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}

	public ExportExcelUtil(HSSFWorkbook workbook, HSSFSheet sheet) {
		super();
		this.workbook = workbook;
		this.sheet = sheet;
	}

	/**
	 * 创建通用的Excel空白行信息
	 * 
	 * @param workbook
	 *            如果为空 则没有样式
	 * @param sheet
	 *            (创建sheet)
	 * @param rowNO
	 *            报表的单行行号(创建第几行)
	 * @param rowHeight
	 *            报表的单行行高
	 * @param colNum
	 *            报表的总列数 (合并)
	 */
	public void createExcelRow(HSSFWorkbook workbook, HSSFSheet sheet, int rowNO, int rowHeight, int colNum) {
		createExcelRow(workbook, sheet, rowNO, -1, colNum, null, -1, null, null);
	}

	/**
	 * 创建通用的Excel带标题行信息
	 * 
	 * @param workbook
	 *            如果为空 则没有样式
	 * @param sheet
	 *            (创建sheet)
	 * @param rowNO
	 *            报表的单行行号(创建第几行)
	 * @param rowHeight
	 *            报表的单行行高
	 * @param colNum
	 *            报表的总列数 (合并)
	 * @param fontCaption
	 *            报表行中显示的字符
	 */
	public void createExcelRow(HSSFWorkbook workbook, HSSFSheet sheet, int rowNO, int rowHeight, int colNum,
			String fontCaption) {
		createExcelRow(workbook, sheet, rowNO, -1, colNum, fontCaption, -1, null, null);
	}

	/**
	 * 创建通用的Excel行信息
	 * 
	 * @param workbook
	 *            如果为空 则没有样式
	 * @param sheet
	 *            (创建sheet)
	 * @param rowNO
	 *            报表的单行行号(创建第几行)
	 * @param rowHeight
	 *            报表的单行行高
	 * @param colNum
	 *            报表的总列数 (合并)
	 * @param fontCaption
	 *            报表行中显示的字符
	 * @param fontSize
	 *            字体的大小 (字体大小 默认 200)
	 * @param fontWeight
	 *            报表表头显示的字符
	 * @param align
	 *            字体水平位置 (center中间 right右 left左)
	 * @param colNum
	 *            报表的列数
	 */
	@SuppressWarnings("deprecation")
	public void createExcelRow(HSSFWorkbook workbook, HSSFSheet sheet, int rowNO, int rowHeight, int colNum,
			String fontCaption, int fontSize, String fontWeight, String align) {
		if (colNum < 0) {
			logger.debug(this.getClass().getName() + " --> Excel column number is null");
			colNum = 100;
		}

		HSSFRow row = sheet.createRow(rowNO); // 创建第一行
		row.setHeight((short) (rowHeight < 1 ? 300 : rowHeight)); // 设置行高

		HSSFCell cell = row.createCell(0);// 设置第一行
		cell.setCellType(HSSFCell.ENCODING_UTF_16); // 定义单元格为字符串类型
		cell.setCellValue(new HSSFRichTextString(fontCaption));

		// sheet.addMergedRegion(new CellRangeAddress(rowNO, (short) 0, rowNO,
		// (short) (colNum - 1))); //指定合并区域

		HSSFCellStyle cellStyle = createCellFontStyle(workbook, fontSize, fontWeight, align, null); // 设定样式
		if (cellStyle != null) {
			cell.setCellStyle(cellStyle);
		}
	}

	/**
	 * 设置报表列头
	 * 
	 * @param sheet
	 *            (创建sheet)
	 * @param rowNO
	 *            报表的单行行号(创建第几行)
	 * @param rowHeight
	 *            报表的单行行高
	 * @param columnHeader
	 *            报表行中显示的字符
	 */
	public void createColumnHeader(HSSFSheet sheet, int rowNO, int rowHeight, String[] columnHeader) {
		createColumnHeader(sheet, rowNO, rowHeight, columnHeader, -1, null, null);
	}

	/**
	 * 设置报表列头
	 * 
	 * @param sheet
	 *            (创建sheet)
	 * @param rowNO
	 *            报表的单行行号(创建第几行)
	 * @param rowHeight
	 *            报表的单行行高
	 * @param columnHeader
	 *            报表行中显示的字符
	 * @param fontSize
	 *            字体的大小 (字体大小 默认 200)
	 */
	public void createColumnHeader(HSSFSheet sheet, int rowNO, int rowHeight, String[] columnHeader, int fontSize) {
		createColumnHeader(sheet, rowNO, rowHeight, columnHeader, fontSize, null, null);
	}

	public void createColumnHeader(HSSFSheet sheet, int rowNO, int rowHeight, String[] columnHeader, int fontSize,
			String fontWeight, String align) {
		createColumnHeader(sheet, rowNO, rowHeight, columnHeader, fontSize, fontWeight, align, null);
	}

	public void createColumnHeader(HSSFSheet sheet, int rowNO, int rowHeight, String[] columnHeader, int fontSize,
			String fontWeight, String align, Short cellColor) {
		createColumnHeader(sheet, rowNO, 0, rowHeight, columnHeader, fontSize, fontWeight, align, cellColor);
	}

	/**
	 * 设置报表列头
	 * 
	 * @param sheet
	 *            (创建sheet)
	 * @param rowNO
	 *            报表的单行行号(创建第几行)
	 * @param beginCellNo
	 *            报表的开始列
	 * @param rowHeight
	 *            报表的单行行高
	 * @param columnHeader
	 *            报表行中显示的字符
	 * @param fontSize
	 *            字体的大小 (字体大小 默认 200)
	 * @param fontWeight
	 *            报表表头显示的字符
	 * @param align
	 *            字体水平位置 (center中间 right右 left左)
	 */
	public void createColumnHeader(HSSFSheet sheet, int rowNO, int beginCellNo, int rowHeight, String[] columnHeader,
			int fontSize, String fontWeight, String align, Short cellColor) {
		if (columnHeader == null || columnHeader.length < 1) {
			logger.debug(this.getClass().getName() + " --> Excel columnHeader is null");
			return;
		}
		HSSFRow row = sheet.createRow(rowNO);
		row.setHeight((short) rowHeight);

		HSSFCellStyle cellStyle = createCellFontStyle(workbook, fontSize, fontWeight, align, null);
		if (cellStyle != null) {
			// 设置单元格背景色
			if (cellColor != null) {
				cellStyle.setFillForegroundColor(cellColor);
			} else {
				cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			}
			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		}

		HSSFCell cell = null;
		for (int i = beginCellNo; i < columnHeader.length + beginCellNo; i++) {
			sheet.setColumnWidth(i, 20 * 256); // 设置列宽，20个字符宽度。宽度参数为1/256，故乘以256
			cell = row.createCell(i);
			cell.setCellType(HSSFCell.ENCODING_UTF_16);
			if (cellStyle != null) {
				cell.setCellStyle(cellStyle);
			}
			cell.setCellValue(new HSSFRichTextString(columnHeader[i]));
		}
	}
	
	public void createColumnHeader(HSSFSheet sheet, int rowNO, int beginCellNo, int rowHeight, String[] columnHeader,
			HSSFCellStyle cellStyle) {
		if (columnHeader == null || columnHeader.length < 1) {
			logger.debug(this.getClass().getName() + " --> Excel columnHeader is null");
			return;
		}
		HSSFRow row = sheet.createRow(rowNO);
		row.setHeight((short) rowHeight);

		/*HSSFCellStyle cellStyle = createCellFontStyle(workbook, fontSize, fontWeight, align, null);
		if (cellStyle != null) {
			// 设置单元格背景色
			if (cellColor != null) {
				cellStyle.setFillForegroundColor(cellColor);
			} else {
				cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			}
			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		}*/

		HSSFCell cell = null;
		for (int i = beginCellNo; i < columnHeader.length + beginCellNo; i++) {
			sheet.setColumnWidth(i, 15 * 256); // 设置列宽，20个字符宽度。宽度参数为1/256，故乘以256
			cell = row.createCell(i);
			cell.setCellType(HSSFCell.ENCODING_UTF_16);
			if (cellStyle != null) {
				cell.setCellStyle(cellStyle);
			}
			cell.setCellValue(new HSSFRichTextString(columnHeader[i-beginCellNo]));
		}
	}

	/**
	 * 创建数据行
	 * 
	 * @param sheet
	 *            (创建sheet)
	 * @param rowNO
	 *            报表的单行行号(创建第几行)
	 * @param rowHeight
	 *            报表的单行行高
	 * @param columnData
	 *            报表行中显示的数据
	 * @param maxValue
	 *            Excel显示的最大上限
	 */
	public HSSFSheet createColumnData(HSSFSheet sheet, int rowNO, String[][] columnData, int maxValue) {
		maxValue = (maxValue < 1 || maxValue > 65535) ? 65535 : maxValue;
		int currRowNO = rowNO;
		for (int numNO = currRowNO; numNO < columnData.length + currRowNO; numNO++) {
			if (numNO % maxValue == 0) {
				sheet = workbook.createSheet();
				rowNO = 0;
			}
			createColumnDataDesc(sheet, numNO, rowNO, currRowNO, -1, columnData);
			rowNO++;
		}
		return sheet;
	}

	/**
	 * 创建数据行
	 * 
	 * @param sheet
	 *            (创建sheet)
	 * @param numNO
	 *            序列号
	 * @param rowNO
	 *            报表的单行行号(创建第几行)
	 * @param currRowNO
	 *            初始行号
	 * @param rowHeight
	 *            报表的单行行高
	 * @param columnData
	 *            报表行中显示的数据
	 */
	private void createColumnDataDesc(HSSFSheet sheet, int numNO, int rowNO, int currRowNO, int rowHeight,
			String[][] columnData) {
		createColumnDataDesc(sheet, numNO, rowNO, currRowNO, rowHeight, columnData, -1, null, null);
	}

	/**
	 * 创建数据行
	 * 
	 * @param sheet
	 *            (创建sheet)
	 * @param rowNO
	 *            报表的单行行号(创建第几行)
	 * @param rowHeight
	 *            报表的单行行高
	 * @param columnData
	 *            报表行中显示的数据
	 * @param fontSize
	 *            字体大小 默认 200
	 * @param fontWeight
	 *            字体粗细 ( 值为bold 为加粗)
	 * @param align
	 *            字体水平位置 (center中间 right右 left左)
	 * @param maxValue
	 *            Excel显示的最大上限
	 */
	public HSSFSheet createColumnData(HSSFSheet sheet, int rowNO, int rowHeight, String[][] columnData, int fontSize,
			String fontWeight, String align, int maxValue) {
		maxValue = (maxValue < 1 || maxValue > 65535) ? 65535 : maxValue;
		int currRowNO = rowNO;
		for (int numNO = currRowNO; numNO < columnData.length + currRowNO; numNO++) {
			if (numNO % maxValue == 0) {
				sheet = workbook.createSheet();
				rowNO = 0;
			}
			createColumnDataDesc(sheet, numNO, rowNO, currRowNO, rowHeight, columnData, fontSize, fontWeight, align);
			rowNO++;
		}
		return sheet;
	}

	/**
	 * 创建数据行
	 * 
	 * @param sheet
	 *            (创建sheet)
	 * @param numNO
	 *            序列号
	 * @param rowNO
	 *            报表的单行行号(创建第几行)
	 * @param currRowNO
	 *            初始行号
	 * @param rowHeight
	 *            报表的单行行高
	 * @param columnData
	 *            报表行中显示的数据
	 * @param fontSize
	 *            字体的大小 (字体大小 默认 200)
	 * @param fontWeight
	 *            报表表头显示的字符
	 * @param align
	 *            字体水平位置 (center中间 right右 left左)
	 */
	private void createColumnDataDesc(HSSFSheet sheet, int numNO, int rowNO, int currRowNO, int rowHeight,
			String[][] columnData, int fontSize, String fontWeight, String align) {
		if (columnData == null || columnData.length < 1) {
			logger.debug(this.getClass().getName() + " --> Excel columnData is null");
			// return ;
		}
		HSSFRow row = sheet.createRow(rowNO);
		row.setHeight((short) rowHeight);

		HSSFCellStyle cellStyle = null;// createCellFontStyle(workbook,
										// fontSize, fontWeight, align);
		if (cellStyle != null) {
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 指定单元格居中对齐
		} else {
			cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION); // 指定单元格居中对齐
		}
		HSSFCell cell = null;
		for (int i = 0; i < columnData[numNO - currRowNO].length; i++) {
			sheet.setColumnWidth(i, 20 * 256); // 设置列宽，20个字符宽度。宽度参数为1/256，故乘以256
			cell = row.createCell(i);
			cell.setCellType(HSSFCell.ENCODING_UTF_16);
			if (cellStyle != null) {
				cell.setCellStyle(cellStyle);
			}
			cell.setCellValue(new HSSFRichTextString(columnData[numNO - currRowNO][i]));
		}
	}

	/**
	 * 创建内容单元格
	 * 
	 * @param workbook
	 *            HSSFWorkbook
	 * @param row
	 *            HSSFRow
	 * @param columnNumber
	 *            short型的列索引
	 * @param alignType
	 *            对齐方式 (默认居中对齐,如果 alignType=true 则左对齐)
	 * @param value
	 *            列值
	 */
	@SuppressWarnings("deprecation")
	public void cteateDataCell(HSSFWorkbook workbook, HSSFRow row, int columnNumber, boolean alignType, String value) {
		HSSFCell cell = row.createCell(((short) columnNumber));
		cell.setCellType(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue(new HSSFRichTextString(value));

		HSSFCellStyle cellstyle = workbook.createCellStyle();
		short align = HSSFCellStyle.ALIGN_CENTER_SELECTION;
		if (alignType) {
			align = HSSFCellStyle.ALIGN_LEFT;
		}
		cellstyle.setAlignment(align); // 指定单元格居中对齐
		cell.setCellStyle(cellstyle);
	}


	/**
	 * 设置字体样式 (字体为宋体 ，上下居中对齐，可设置左右对齐，字体粗细，字体大小 )
	 * 
	 * @param workbook
	 *            如果为空 则没有样式
	 * @param fontSize
	 *            字体大小 默认 200
	 * @param fontWeight
	 *            字体粗细 ( 值为bold 为加粗)
	 * @param align
	 *            字体水平位置 (center中间 right右 left左)
	 */
	public HSSFCellStyle createCellFontStyle(HSSFWorkbook workbook, int fontSize, String fontWeight, String align, Short cellColor) {
		if (workbook == null) {
			logger.debug(this.getClass().getName() + " --> Excel HSSFWorkbook FontStyle is not set");
			return null;
		}

		HSSFCellStyle cellStyle = workbook.createCellStyle();
		
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
		if (align != null && align.equalsIgnoreCase("left")) {
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 指定单元格居中对齐
		}
		if (align != null && align.equalsIgnoreCase("right")) {
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT); // 指定单元格居中对齐
		}

		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
		cellStyle.setWrapText(true);// 指定单元格自动换行
		
		// 设置单元格背景色
		if(cellColor != null) {
			cellStyle.setFillForegroundColor(cellColor);
		} else {
			cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		}
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		
		// 边框设置
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

		// 单元格字体
		HSSFFont font = workbook.createFont();
		if (fontWeight != null && fontWeight.equalsIgnoreCase("normal")) {
			font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		} else {
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		}

		font.setFontName("宋体");
		font.setFontHeight((short) (fontSize < 1 ? 200 : fontSize));
		cellStyle.setFont(font);

		// 设置字体
		// HSSFFont font = workbook.createFont();
		// font.setFontHeightInPoints((short) 20); //字体高度
		// font.setColor(HSSFFont.COLOR_RED); //字体颜色
		// font.setFontName("黑体"); //字体
		// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //宽度
		// font.setItalic(true); //是否使用斜体
		// font.setStrikeout(true); //是否使用划线
		// // 添加单元格注释
		// // 创建HSSFPatriarch对象,HSSFPatriarch是所有注释的容器.
		// HSSFPatriarch patr = sheet.createDrawingPatriarch();
		// // 定义注释的大小和位置,详见文档
		// HSSFComment comment = patr.createComment(new HSSFClientAnchor(0, 0,
		// 0, 0, (short)4, 2, (short) 6, 5));
		// // 设置注释内容
		// comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		// // 设置注释作者. 当鼠标移动到单元格上是可以在状态栏中看到该内容.
		// comment.setAuthor("Xuys.");

		return cellStyle;
	}
	
	public void exportExcel(String fileName) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(new File(fileName));
			workbook.write(os);
			os.close();
		} catch (Exception e) {
			logger.debug(this.getClass().getName() + " --> export Excel file error :" + e.getMessage());
		}
	}

	public static String getCellValue(HSSFCell cell) {
		 String cellValue = "";  
        if(cell == null){  
            return cellValue;  
        }  
        //把数字当成String来读，避免出现1读成1.0的情况  
//        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){  
//            cell.setCellType(HSSFCell.CELL_TYPE_STRING);  
//        }  
        //判断数据的类型  
        switch (cell.getCellType()){
            case HSSFCell.CELL_TYPE_NUMERIC: //数字  
            	if(HSSFDateUtil.isCellDateFormatted(cell)){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                }
                cellValue = String.valueOf(cell.getNumericCellValue());  
                break;  
            case HSSFCell.CELL_TYPE_STRING: //字符串  
                cellValue = String.valueOf(cell.getStringCellValue());  
                break;  
            case HSSFCell.CELL_TYPE_BOOLEAN: //Boolean  
                cellValue = String.valueOf(cell.getBooleanCellValue());  
                break;  
            case HSSFCell.CELL_TYPE_FORMULA: //公式  
                cellValue = String.valueOf(cell.getCellFormula());  
                break;  
            case HSSFCell.CELL_TYPE_BLANK: //空值   
                cellValue = "";  
                break;  
            case HSSFCell.CELL_TYPE_ERROR: //故障  
                cellValue = "非法字符";  
                break;  
            default:  
                cellValue = "未知类型";  
                break;  
        }  
        return cellValue;  
	}

}