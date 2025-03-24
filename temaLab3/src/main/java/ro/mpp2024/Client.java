package ro.mpp2024;
public class Client implements Identifiable<Integer> {
    private String nume;
    private String prenume;
    private int id;

   public Client(String nume, String prenume) {
       this.nume = nume;
       this.prenume = prenume;
   }

    public String getNume() {
       return nume;
    }
    public void setNume(String nume) {
       this.nume = nume;
    }
    public String getPrenume() {
       return prenume;
    }
    public void setPrenume(String prenume) {
       this.prenume = prenume;
    }
    @Override
    public void setId(Integer id) {
        this.id=id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id=" + id + " " + nume + ' ' + prenume ;
    }
}
