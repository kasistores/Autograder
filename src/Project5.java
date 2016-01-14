// Kevin Asistores
// kasistores
// 5993
// project number : Project 5
// Spelling Check

import java.util.*;
import java.io.*;

//what to do if you red 11111111 as the dictionary file because it works?
public class Project5 {
	public static void main(String[] args) {
		ArrayList<String> dictionary = new ArrayList<>();
		ArrayList<Student> Students = new ArrayList<Student>();

		boolean statement = true;
		do{
		Scanner console = new Scanner(System.in);
		Scanner fileInput;
		Scanner secondFileInput;
		System.out.println("Please specify the name of the file that contains the dictionary information.\n");
			String fileName = console.next();
			
			//this is the first try statement reads the dictionary
			//----------------------------------
			try{
				int num = 0;
				File inputFile = new File(fileName + ".txt");
				fileInput = new Scanner(inputFile);
				System.out.println("\nFile opened successfully!\n");
				while(fileInput.hasNextLine()){
					dictionary.add(fileInput.nextLine());
				}
				replace(dictionary);

				//this separates finding the dicitonary and finding the actual text file
				//----------------------------------
				boolean secondStatement = true;
				do{
				System.out.println("Please specify the ID of the student whose essay will be graded.\n");
					//console.nextLine();
					String secondFileName = console.next();
					
					if (secondFileName.toLowerCase().equals("finished")){
						secondStatement = false;
						break;
					}							
					
					
					// reading the file
					try {
						File secondInputFile = new File(secondFileName + ".txt");
						secondFileInput = new Scanner(secondInputFile);
							System.out.println("\nFile opened successfully!\n");
							//secondFileInput.nextLine();
							String student = secondFileInput.nextLine();
								
								//if it is a graduate student
								if (student.replaceAll("\\s", "").equalsIgnoreCase("graduatestudent")){
									PrintWriter out = new PrintWriter(secondFileName + "_graded.txt");
									num++;
									int point = 100;
									int misspelled = 0;
									String name = secondFileInput.nextLine();
									int id = Integer.parseInt(secondFileInput.nextLine());
									String major = secondFileInput.nextLine();
									String advisor = secondFileInput.nextLine();
									GraduateStudent g = new GraduateStudent(name, id, major, advisor);
									Students.add(g);
									ArrayList<String> moogle = new ArrayList<>();
									
									while(secondFileInput.hasNext()){
										moogle.add(secondFileInput.next());
									}
										for (int j = 0; j < num; j++ ){
											if (Students.get(j) instanceof GraduateStudent && Students.get(j).getIDNumber().equals(secondFileName)){
												String[] strArray = moogle.toString().trim().replaceAll("^\\[|\\]$", "").replaceAll("[\\., ]", " ").split("\\s+");
												ArrayList<String> misspell = new ArrayList<>();
												for(int i = 0; i < strArray.length; i++){
													if (dictionary.contains(strArray[i].toLowerCase())){
														point = point;
													}
													else if (!dictionary.contains(strArray[i])){
														point = point - 5;
														misspelled++;
														misspell.add(strArray[i]);
														if (point <= 0){
															point = 0;
														}
													}
													
												}
												out.print(Students.get(j).toString());
												out.println("Received a score of " + point + " with " + misspelled + " misspelled words:");
												for (int i = 0; i < misspelled; i++){
													out.println("(" + (i+1) + ")" + misspell.get(i));
												}
											}
											else
												continue;
										}
										out.close();
								}
								
								//if it is an undergraduate student
								else if (student.replaceAll("\\s", "").equalsIgnoreCase("undergraduatestudent")){
									PrintWriter in = new PrintWriter(secondFileName + "_graded.txt");
									num++;
									int point = 100;
									int misspelled = 0;
									String name = secondFileInput.nextLine();
									int id = Integer.parseInt(secondFileInput.nextLine());
									String major = secondFileInput.nextLine();
									UndergraduateStudent u = new UndergraduateStudent(name, id, major);
									Students.add(u);
									ArrayList<String> moogle = new ArrayList<>();
									
									while(secondFileInput.hasNext()){
										moogle.add(secondFileInput.next());
									}
										for (int j = 0; j < num; j++ ){
											if (Students.get(j) instanceof UndergraduateStudent && Students.get(j).getIDNumber().equals(secondFileName)){
												String[] strArray = moogle.toString().trim().replaceAll("^\\[|\\]$", "").replaceAll("[\\., ]", " ").split("\\s+");
												ArrayList<String> misspellOne = new ArrayList<>();
												for(int i = 0; i < strArray.length; i++){
														if (dictionary.contains(strArray[i].toLowerCase())){
															point = point;
														}
														else if (!dictionary.contains(strArray[i])){
															point = point - 3;
															misspelled++;
															misspellOne.add(strArray[i]);
															if (point <= 0){
																point = 0;
															}
														}
													
												}
												in.print(Students.get(j).toString());
												in.println("Received a score of " + point + " with " + misspelled + " misspelled words:");
												for (int i = 0; i < misspelled; i++){
													in.println("(" + (i+1) + ")" + misspellOne.get(i));
												}
											}
											else
												continue;
										}
										in.close();
								}
								
								//if it is a highschool student
								else if (student.replaceAll("\\s", "").equalsIgnoreCase("highschoolstudent")){
									PrintWriter on = new PrintWriter(secondFileName + "_graded.txt");
									num++;
									int point = 100;
									int misspelled = 0;
									String name = secondFileInput.nextLine();
									int id = Integer.parseInt(secondFileInput.nextLine());
									String schoolName = secondFileInput.nextLine();
									HighSchoolStudent h = new HighSchoolStudent(name, id, schoolName);
									Students.add(h);
									ArrayList<String> google = new ArrayList<>();
									
									while(secondFileInput.hasNext()){
										google.add(secondFileInput.next());
									}
										for (int j = 0; j < num; j++ ){
											if (Students.get(j) instanceof HighSchoolStudent && Students.get(j).getIDNumber().equals(secondFileName)){
												String[] strArray = google.toString().trim().replaceAll("^\\[|\\]$", "").replaceAll("[\\., ]", " ").split("\\s+");
												ArrayList<String> misspellTwo = new ArrayList<>();
												
												for(int i = 0; i < strArray.length; i++){
														if (dictionary.contains(strArray[i].toLowerCase())){
															point = point;
														}
														else if (!dictionary.contains(strArray[i])){
															point = point - 1;
															misspelled++;
															misspellTwo.add(strArray[i]);
															if (point <= 0){
																point = 0;
															}
														}
													
												}
												on.print(Students.get(j).toString());
												on.println("Received a score of " + point + " with " + misspelled + " misspelled words:");
												for (int i = 0; i < misspelled; i++){
													on.println("(" + (i+1) + ")" + misspellTwo.get(i).toString());
												}
												
											}
											else
												continue;
										}
									on.close();
								}
								
						secondStatement = true;
					}
					catch(FileNotFoundException ex){
						System.out.println("\nFile " + secondFileName + " cannot be found!\n");
						secondStatement = true;
					}
				}while (secondStatement = true);
				
				
				
				
				
				//continuation of first do and try loop
				//----------------------------------
				statement = false;
				break;
			}
			catch (FileNotFoundException e){
				System.out.println("\nFile " + fileName + " cannot be found!\n");
				statement = true;
			}
		}while (statement = true);
		System.exit(0);
	}
	
	public static void replace(List<String> strings)
	{
	    ListIterator<String> iterator = strings.listIterator();
	    while (iterator.hasNext())
	    {
	        iterator.set(iterator.next().toLowerCase());
	    }
	}

	
}
