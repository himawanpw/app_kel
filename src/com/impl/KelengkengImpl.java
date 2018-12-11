package com.impl;

import com.entities.Kelengkeng;
import com.interfaces.KelengkengInt;
import com.util.ConnectionConfig;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KelengkengImpl implements KelengkengInt {

    @Override
    public void createTableKelengkeng() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE kelengkeng(id int primary key unique AUTO_INCREMENT,jenis varchar (50),harga double )");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void createTableTransaksi() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE transaksi(id int primary key unique AUTO_INCREMENT,harga_bayar double)");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void insert(Kelengkeng kelengkeng) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;//protect from injection
        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO kelengkeng(jenis,harga) VALUE (?,?)");
            preparedStatement.setString(1, kelengkeng.getJenis_kelengkeng());
            preparedStatement.setDouble(2, kelengkeng.getHarga());
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO kelengkeng(jenis,harga) ," +
                    "VALUE (?,?)");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Kelengkeng selectByName(String jenis) {
        Kelengkeng kelengkeng = new Kelengkeng();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM kelengkeng where id = ?");
            preparedStatement.setString(1, jenis);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                kelengkeng.setId_kelengkeng(resultSet.getInt("id"));
                kelengkeng.setJenis_kelengkeng(resultSet.getString("jenis"));
                kelengkeng.setHarga(resultSet.getDouble("harga"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return kelengkeng;
    }

    @Override
    public List<Kelengkeng> selectAll() {
        List<Kelengkeng> kelengkengs = new ArrayList<Kelengkeng>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM kelengkeng");
            Kelengkeng kelengkeng = new Kelengkeng();
            while (resultSet.next()) {
                //kelengkeng.setId_kelengkeng(resultSet.getInt("id"));
                //kelengkeng.setJenis_kelengkeng(resultSet.getString("jenis"));
                //kelengkeng.setHarga(resultSet.getDouble("harga"));
                int id = resultSet.getInt("id");
                String jenis = resultSet.getString("jenis");
                double harga = resultSet.getDouble("harga");
                System.out.print(id+" "+jenis+" "+harga);
                System.out.println(" ");
                kelengkengs.add(kelengkeng);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return kelengkengs;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM kelengkeng where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("DELETE FROM kelengkeng where id = ?");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Kelengkeng kelengkeng, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE kelengkeng SET jenis=?,harga=? where id=?");
            preparedStatement.setString(1, kelengkeng.getJenis_kelengkeng());
            preparedStatement.setDouble(2, kelengkeng.getHarga());
            preparedStatement.setInt(3, kelengkeng.getId_kelengkeng());
            preparedStatement.executeUpdate();

            System.out.println("UPDATE kelengkeng SET jenis=?,harga=? where id=?");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void calculate(Kelengkeng kelengkeng) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        double price,back;
        try {
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement("SELECT harga from kelengkeng where jenis=?");
            preparedStatement.setString(1, kelengkeng.getJenisSearch());
            resultSet = preparedStatement.executeQuery();
            resultSet.beforeFirst();
            resultSet.next();
            price = resultSet.getDouble("harga");
            double calcultedPrice = kelengkeng.getJumlahBeli() * price;
            preparedStatement = connection.prepareStatement("INSERT INTO transaksi(harga_bayar,tanggal) value (?,?)");
            preparedStatement.setDouble(1, calcultedPrice);
            preparedStatement.setDate(2,sqlDate);
            preparedStatement.executeUpdate();
            back = kelengkeng.getBayar()-calcultedPrice;
            System.out.println("Kembalian = "+back);
            System.out.println("INSERT INTO table transaksi(harga_bayar) value (?)");
            preparedStatement.close();
            preparedStatement = connection.prepareStatement("INSERT INTO detail_transaksi(jenis,harga,tanggal) value (?,?,?)");
            preparedStatement.setString(1,kelengkeng.getJenisSearch());
            preparedStatement.setDouble(2,calcultedPrice);
            preparedStatement.setDate(3,sqlDate);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Kelengkeng> showHistory() {
            List<Kelengkeng> kelengkengs = new ArrayList<Kelengkeng>();
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                connection = ConnectionConfig.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM detail_transaksi");
                Kelengkeng kelengkeng = new Kelengkeng();
                while (resultSet.next()) {
                    String jenis = resultSet.getString("jenis");
                    System.out.print(jenis+ " ");
                    kelengkengs.add(kelengkeng);
                    double harga = resultSet.getDouble("harga");
                    System.out.print(harga+" ");
                    java.sql.Date sqlDate = resultSet.getDate("tanggal");
                    java.util.Date sqlConverted = new java.util.Date(sqlDate.getTime());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    System.out.print(format.format(sqlConverted));
                    kelengkengs.add(kelengkeng);
                }
                System.out.println(" ");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            return kelengkengs;
        }

    @Override
    public void addAdmin(Kelengkeng kelengkeng) {
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO admin(username,password) value (?,?)");
            preparedStatement.setString(1,kelengkeng.getUsername());
            preparedStatement.setString(2,kelengkeng.getPassword());
            preparedStatement.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delAdmin(int id) {
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement("DELETE from admin where id_admin=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void loginAdmin(Kelengkeng kelengkeng) {
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet= null;
        try {
            connection=ConnectionConfig.getConnection();
            preparedStatement=connection.prepareStatement("select username,password from admin");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String checkUser = resultSet.getString("username");
                String checkPass = resultSet.getString("password");
                if((kelengkeng.getUsernameDum().equals(checkUser))&&(kelengkeng.getPasswordDum().equals(checkPass))){
                    System.out.println("Login Success");
                }
                else {
                    System.out.println("Login Failed");
                    System.exit(0);
                }
            }
//            while (resultSet.next()){
//             kelengkeng.setUsernameDum(resultSet.getString("username"));
//             kelengkeng.setPasswordDum(resultSet.getString("password"));
//             kelengkeng.setId_kelengkeng(resultSet.getInt("id_admin"));
//             kelengkengs.add(kelengkeng);
//            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}