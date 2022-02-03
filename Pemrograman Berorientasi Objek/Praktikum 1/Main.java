public class Main {

    public static void main(String[] args) {
        
        String name, grade, major,faculty, NIM ;

        name    = "Ronaldi";
        grade   = "H" ;
        major   = "Informatika";
        faculty = "Teknik";
        NIM     = "202010370311377";

        Mahasiswa a1=new Mahasiswa() ;

        a1.setName(name);
        a1.setGrade(grade);
        a1.setMajor(major);
        a1.setFaculty(faculty);
        a1.setNIM(NIM);

        a1.TampilData ();


    }
}