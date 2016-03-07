package ua.oracleacademy.fp.dao.jdbc;

import ua.oracleacademy.fp.dao.UserDao;
import ua.oracleacademy.fp.domain.users.Client;
import ua.oracleacademy.fp.domain.users.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class JdbcUserDao implements UserDao {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users "
                + "(LOGIN, PASSWORD, NAME, ENABLED, ADMIN) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            Statement statement = conn.createStatement();

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setBoolean(4, true);
            ps.setBoolean(5, false);

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }  finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {

                }
            }
        }
    }

    @Override
    public User findUserById(long id) {
        String sql = "SELECT * FROM users WHERE USER_ID = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            User user = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if(!rs.getBoolean("ADMIN")) {
                    user = new Client(
                            rs.getLong("USER_ID"),
                            rs.getString("NAME"),
                            rs.getString("LOGIN"),
                            rs.getString("PASSWORD"),
                            rs.getBoolean("ENABLED")
                    );
                }
            }
            rs.close();
            ps.close();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }


    @Override
    public User findUserByLogin(String login) {
        String sql = "SELECT * FROM users WHERE LOGIN = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            User user = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if(!rs.getBoolean("ADMIN")) {
                    user = new Client(
                            rs.getLong("USER_ID"),
                            rs.getString("NAME"),
                            rs.getString("LOGIN"),
                            rs.getString("PASSWORD"),
                            rs.getBoolean("ENABLED")
                    );
                }
            }
            rs.close();
            ps.close();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }


    @Override
    public void deleteUser(long id) {
        String sql = "DELETE FROM users WHERE USER_ID = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();

            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {

                }
            }
        }
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users SET LOGIN = ?, NAME = ?, PASSWORD = ?, ENABLED = TRUE, ABOUT = ? WHERE USER_ID = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getLogin());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getAbout());
            ps.setLong  (5, user.getId());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {

                }
            }
        }
    }

    @Override
    public List <User> getAllUsers() {
        List users = new ArrayList <User>() {
        };

        String sql = "SELECT * FROM users";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            User user = null;

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if(!rs.getBoolean("ADMIN")) {
                    user = new Client(
                            rs.getLong("USER_ID"),
                            rs.getString("NAME"),
                            rs.getString("LOGIN"),
                            rs.getString("PASSWORD"),
                            rs.getBoolean("ENABLED")
                    );
                    users.add(user);
                }
            }
            rs.close();
            ps.close();

            return users;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void makeAdmin(long userId) { String sql = "UPDATE users SET ADMIN = TRUE WHERE USER_ID = ?";

    Connection conn = null;

    try {
        conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setLong   (1, userId);

        ps.executeUpdate();

        ps.close();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    } finally {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {

            }
        }
    }


    }}

