

public class Mahasiswa {

    public String name, grade, major,faculty, NIM ;

    public void setName (String a){
       this.name = a ;
    }
    public void setGrade (String b){
        this.grade = b ;
    }
    public void setMajor (String c){
        this.major = c ;
    }
    public void setFaculty (String d){
        this.faculty = d ;
    }
    public void setNIM (String e){
        this.NIM = e ;
    }

    String getName (){
        return this.name ;
    }
    String getGrade (){
        return this.grade ;
    }
    String getMajor (){
        return this.major ;
    }
    String getFaculty (){
        return this.faculty ;
    }
    String getNIM (){
        return this.NIM ;
    }

    public void TampilData (){
     
    System.out.println("Nama \t\t: "+getName());
    System.out.println("Kelas \t\t: "+getGrade());
    System.out.println("Jurusan \t: "+getMajor());
    System.out.println("Fakultas \t: "+getFaculty());
    System.out.println("NIM \t\t: "+getNIM());
    }
}