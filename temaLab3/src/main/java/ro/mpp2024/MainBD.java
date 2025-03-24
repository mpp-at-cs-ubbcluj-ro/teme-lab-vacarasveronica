package ro.mpp2024;
import java.io.*;
import java.util.Properties;


public class MainBD {
    public static void main(String[] args) throws IOException {

        InputStream input = MainBD.class.getClassLoader().getResourceAsStream("bd.config");
        if (input == null) {
            throw new FileNotFoundException("bd.config not found in resources");
        }
        Properties props = new Properties();
        props.load(input);
        System.out.println(props);

        ClientRepository clientRepo=new ClientDBRepository(props);
        clientRepo.add(new Client("Ana","Maria"));
        clientRepo.add(new Client("Bogdan","Pop"));
        System.out.println("Toti clientii din db");
        for(Client cl:clientRepo.findAll())
            System.out.println(cl.getNume()+" "+cl.getPrenume());
        clientRepo.update(3,new Client("Bogdan","Vlad"));
        for(Client cl:clientRepo.findByPrenume("Vlad"))
            System.out.println(cl.getNume()+" "+cl.getPrenume());
    }
}
