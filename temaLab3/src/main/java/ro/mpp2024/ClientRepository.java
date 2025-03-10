package ro.mpp2024;
import java.util.List;

public interface ClientRepository extends Repository<Integer,Client> {
    List<Client> findByNume(String nume);
    List<Client> findByPrenume(String prenume);
}
