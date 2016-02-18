package com.siri.core;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PDFSearchForKeyword {

	public static void main(String[] args) throws IOException {
		PDDocument pd ;
		PDFTextStripper stripper;
		Boolean keywordExists = false;
		
		//Path where my PDF files are present
		String path = "D:\\BlockListPapers";
		
		//Keyword that is searched for in the PDF files
		String keyword = "Conference or Journal Name: First International Conference on Emerging Trends in Engineering and Technology, 2008. ICETET '08";
		keyword = keyword.replace(" ", "");
		
		//List of all files present in the 'path'
		File[] listOfFiles = new File(path).listFiles();
		try
		{
			for(File f: listOfFiles)
			{
				System.out.println("File name: "+f);

				pd = PDDocument.load(f);
				stripper = new PDFTextStripper();
				stripper.setLineSeparator("");
				String text = stripper.getText(pd).replace(" ", "");
				if(text.toLowerCase().contains(keyword.toLowerCase()))
				{
					keywordExists = true;
				}
				else
					System.out.println("The keyword doesn't exist");
				
				if(keywordExists)
				{
					System.out.println("The keyword exists in the file: "+f);
					break;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
	}

}
