package com.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.demo.model.excelVO;

import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/uploadFile")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = (String) request.getParameter("action");
		System.out.println("action===" + action);
		if ("page".equals(action)) {
			RequestDispatcher sucessView = request.getRequestDispatcher("/upload/uploadExcel.jsp");
			sucessView.forward(request, response);
			return;
		}
		List<excelVO> list = new LinkedList<>();

		Part file = request.getPart("file");
		if(file!=null) {
			InputStream in = file.getInputStream();

			Workbook workbook = WorkbookFactory.create(in);
			Sheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			for (int i = 1; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				excelVO vo = new excelVO();
				DataFormatter d = new DataFormatter();
				vo.setCurrency(getValue(row.getCell(0)));
				
				vo.setBuyRate(getValue(row.getCell(1)));
				vo.setBuyCash(getValue(row.getCell(2)));
				vo.setBuyInTime(getValue(row.getCell(3)));
				vo.setBuyDay10(getValue(row.getCell(4)));
				vo.setBuyDay30(getValue(row.getCell(5)));
				vo.setBuyDay60(getValue(row.getCell(6)));
				vo.setBuyDay90(getValue(row.getCell(7)));
				vo.setBuyDay120(getValue(row.getCell(8)));
				vo.setBuyDay150(getValue(row.getCell(9)));
				vo.setBuyDay180(getValue(row.getCell(10)));

				vo.setSellRate(getValue(row.getCell(11)));
				vo.setSellCash(getValue(row.getCell(12)));
				vo.setSellInTime(getValue(row.getCell(13)));
				vo.setSellDay10(getValue(row.getCell(14)));
				vo.setSellDay30(getValue(row.getCell(15)));
				vo.setSellDay60(getValue(row.getCell(16)));
				vo.setSellDay90(getValue(row.getCell(17)));
				vo.setSellDay120(getValue(row.getCell(18)));
				vo.setSellDay150(getValue(row.getCell(19)));
				vo.setSellDay180(getValue(row.getCell(20)));
				System.out.println(vo);
				list.add(vo);
			}
		}
		
		System.out.println("LIST ==="+list);
		RequestDispatcher sucessView = request.getRequestDispatcher("/upload/uploadExcel.jsp");
		request.setAttribute("excelList", list);
		sucessView.forward(request, response);
		return;
		
		
		
		
	}
	   private String getValue(Cell cell) {
           if (cell.getCellType() == CellType.BOOLEAN) {
                // 返回布爾類型的值
               return String.valueOf(cell.getBooleanCellValue());
               } else if (cell.getCellType() == CellType.NUMERIC) {
                // 返回數值類型的值
              return String.valueOf(cell.getNumericCellValue());
          } else {
               // 返回字符串類型的值
               return String.valueOf(cell.getStringCellValue());
            }
       }     
}
