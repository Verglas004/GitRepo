import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PullSpellInfo {
	ArrayList<Spell> spellList = new ArrayList<Spell>();

	public PullSpellInfo() {
		readExcelSheet();
		//showSpellList();
	}

	private void showSpellList() {
		System.out.println(spellList.size() + " Total Spells");

		for (int i = 0; i < spellList.size(); i++)
			System.out.println(spellList.get(i).toString());
	}
	
	public ArrayList<Spell> getSpellList(){
		return spellList;
	}
	
	private void readExcelSheet() {
		//String filename = getClass().getResource("Spell List.xlsx").getPath();
		// C:\Users\sac\workspace\TempProject\bin\Spell%20List.xlsx
		// String filename =
		// "C:\\Users\\sac\\workspace\\TempProject\\bin\\Spell List.xlsx";
		String filename = "C:\\Git Repo\\TempProject\\src\\Spell List.xlsx";

		try {

			FileInputStream file = new FileInputStream(new File(filename));

			// Get the workbook instance for XLS file
			InputStream inputStream = new FileInputStream(filename);
			Workbook wb = new XSSFWorkbook(inputStream);

			// Get first sheet from the workbook
			Sheet sheet = wb.getSheetAt(0);
			boolean headerRow = true;
			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			int count = 0;
			while (rowIterator.hasNext() && count < 364) {
				count++;
				Row row = rowIterator.next();
				
				if (headerRow) {
					headerRow = false;					
				} else {
					// Name, Description, Page #, Level, School, Casting Time,
					// Ritual, V, S, M, Concentration, Bard, Cleric, Druid,
					// Paladin, Ranger, Sorcerer, Warlock, Wizard
					// 19 columns
					String name = row.getCell(0).getStringCellValue();
					String description = row.getCell(1) != null ? row.getCell(1).getStringCellValue() : "";
					int pg = row.getCell(2).getCellType() == Cell.CELL_TYPE_NUMERIC ? (int) row.getCell(2).getNumericCellValue() : -999;
					int level = (int) row.getCell(3).getNumericCellValue();
					String school = row.getCell(4).getStringCellValue();
					String castingTime = row.getCell(5).getStringCellValue();
					boolean ritual = row.getCell(6).getStringCellValue().equals("x") ? true : false;
					boolean v = row.getCell(7).getStringCellValue().equals("x") ? true: false;
					boolean s = row.getCell(8).getStringCellValue().equals("x") ? true: false;
					boolean m = row.getCell(9).getStringCellValue().equals("x") ? true: false;
					boolean concentration = row.getCell(10).getStringCellValue().equals("x") ? true : false;
					boolean bard = row.getCell(11).getStringCellValue().equals("x") ? true : false;
					boolean cleric = row.getCell(12).getStringCellValue().equals("x") ? true : false;
					boolean druid = row.getCell(13).getStringCellValue().equals("x") ? true : false;
					boolean paladin = row.getCell(14).getStringCellValue().equals("x") ? true : false;
					boolean ranger = row.getCell(15).getStringCellValue().equals("x") ? true : false;
					boolean sorcerer = row.getCell(16).getStringCellValue().equals("x") ? true : false;
					boolean warlock = row.getCell(17).getStringCellValue().equals("x") ? true : false;
					boolean wizard = row.getCell(18).getStringCellValue().equals("x") ? true : false;

					spellList.add(new Spell(name, description, pg, level,
							school, castingTime, ritual, v, s, m,
							concentration, bard, cleric, druid, paladin,
							ranger, sorcerer, warlock, wizard));
				}
			}

			wb.close();
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
