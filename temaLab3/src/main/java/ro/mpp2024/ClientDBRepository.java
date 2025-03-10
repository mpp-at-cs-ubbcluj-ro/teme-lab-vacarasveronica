package ro.mpp2024;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ClientDBRepository implements ClientRepository {

    private JdbcUtils dbUtils;



    private static final Logger logger= LogManager.getLogger();

    public ClientDBRepository(Properties props) {
        logger.info("Initializing CarsDBRepository with properties: {} ",props);
        dbUtils=new JdbcUtils(props);
    }

    @Override
    public void add(Client elem) {
        logger.traceEntry("Saving client {}", elem);
        Connection con = dbUtils.getConnection();

        try (PreparedStatement preStmt = con.prepareStatement(
                "INSERT INTO client (nume, prenume) VALUES (?, ?)")) {
            preStmt.setString(1, elem.getNume());
            preStmt.setString(2, elem.getPrenume());

            int result = preStmt.executeUpdate();
            logger.trace("Saved {} instances", result);
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB " + e);
        }

        logger.traceExit();
    }

    @Override
    public void update(Integer id, Client elem) {
        logger.traceEntry("Updating client {} with id {}", elem, id);
        Connection con = dbUtils.getConnection();

        try (PreparedStatement preStmt = con.prepareStatement(
                "UPDATE client SET nume=?, prenume=? WHERE id=?")) {
            preStmt.setString(1, elem.getNume());
            preStmt.setString(2, elem.getPrenume());
            preStmt.setInt(3, id);

            int result = preStmt.executeUpdate();
            logger.trace("Updated {} instances", result);
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB " + e);
        }

        logger.traceExit();
    }

    @Override
    public Iterable<Client> findAll() {
        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        List<Client> clients = new ArrayList<>();

        try (PreparedStatement preStmt = con.prepareStatement("SELECT * FROM client")) {
            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String nume = result.getString("nume");
                    String prenume = result.getString("prenume");

                    Client client = new Client(nume, prenume);
                    client.setId(id);
                    clients.add(client);
                }
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB " + e);
        }

        logger.traceExit(clients);
        return clients;
    }

    @Override
    public List<Client> findByNume(String nume) {
        logger.traceEntry("Finding clients by nume: {}", nume);
        Connection con = dbUtils.getConnection();
        List<Client> clients = new ArrayList<>();

        try (PreparedStatement preStmt = con.prepareStatement("SELECT * FROM client WHERE nume = ?")) {
            preStmt.setString(1, nume);

            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String prenume = result.getString("prenume");

                    Client client = new Client(nume, prenume);
                    client.setId(id);
                    clients.add(client);
                }
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB " + e);
        }

        logger.traceExit(clients);
        return clients;
    }

    @Override
    public List<Client> findByPrenume(String prenume) {
        logger.traceEntry("Finding clients by prenume: {}", prenume);
        Connection con = dbUtils.getConnection();
        List<Client> clients = new ArrayList<>();

        try (PreparedStatement preStmt = con.prepareStatement("SELECT * FROM client WHERE prenume = ?")) {
            preStmt.setString(1, prenume);

            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String nume = result.getString("nume");

                    Client client = new Client(nume, prenume);
                    client.setId(id);
                    clients.add(client);
                }
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB " + e);
        }

        logger.traceExit(clients);
        return clients;
    }}

