//haim gueta 209500586
//shachar harel

package files;
import java.io.*;


public class repo { 
    public static void main(String[] args) {
        System.out.println("-----start------");
        try {
            write("cs.txt", "hedva.txt");
        } catch (Exception e) {
            System.out.println("error:" );
            System.out.println(e);
        }
    }



    public static void write(String classList, String courseList ) throws IOException {
        
        BufferedReader mainClass = new BufferedReader(new FileReader(classList));
        BufferedReader course = new BufferedReader(new FileReader(courseList));

        String lineFromClass = mainClass.readLine();
        String lineFromCourse = course.readLine();

        FileWriter fw = new FileWriter("report.txt", true);
        PrintWriter pw = new PrintWriter(fw);

        while (lineFromClass != null && lineFromCourse != null) {

            String[] classLineSplit = lineFromClass.split(" ");
            int idClass = Integer.parseInt(classLineSplit[2]);

            String[] courseLineSplit = lineFromCourse.split(" ");
            int idCourse = Integer.parseInt(courseLineSplit[0]);

            if(idClass == idCourse){
                String id = courseLineSplit[0];
                String firstName = classLineSplit[0];
                String lastName = classLineSplit[1];
                double avg = (Integer.parseInt(courseLineSplit[1])+Integer.parseInt(courseLineSplit[2]))/2.0;

                pw.println(id+" "+firstName+" "+lastName+" "+avg );

                lineFromClass = mainClass.readLine();
                lineFromCourse = course.readLine();
            }
            else if (idClass > idCourse) {
                lineFromCourse = course.readLine();
            }
            else{
                lineFromClass = mainClass.readLine();
            }
            
            
        }

        pw.close();
        mainClass.close();
        course.close();
    }
}


