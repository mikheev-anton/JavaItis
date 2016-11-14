package dao;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoFileStringImpl implements UsersDao {

    private File file;

    public UserDaoFileStringImpl(String path) {
        this(new File(path));
    }

    public UserDaoFileStringImpl(File file) {
        this.file = file;
    }

    @Override
    public List<User> findAll() {
        List<User> allUsers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            while (reader.ready()){
                String s = reader.readLine().trim();
                if (!s.isEmpty()){
                    User user = createUser(s);
                    allUsers.add(user);
                }
            }
        }catch (IOException e){
            System.out.println("Файл не найден");
        }
        return allUsers;
    }

    @Override
    public void update(User user) {
//        int id = user.getId();
        try (RandomAccessFile reader = new RandomAccessFile(file,"rw")){
            boolean ouUser = false;
            boolean isCorrectUser = false;
            boolean isSaved = false;
            char[] peaceOfUser = getRepresentString(user).replace("\n"," ").toCharArray();
            int i = 2;
            while (reader.length() > 0){
                char c = reader.readChar();
                if (c ==' '&&!ouUser){
                    ouUser = true;
                    int id = Integer.parseInt(String.valueOf(reader.readChar()));
                    if (id == user.getId()){
                        isCorrectUser = true;
                    }
                }
                if (ouUser&&isCorrectUser){
                    if (i < peaceOfUser.length){
                        reader.writeChar(peaceOfUser[i++]);
                        reader.seek(reader.getFilePointer()-2L);
                    }
                    else if (c != '\n'){
                        isSaved = true;
                        reader.seek(reader.getFilePointer()-2L);
                        reader.writeChars(" ");
                        continue;
                    }
                }
                if (c == '\n'&&!isSaved){
                    ouUser = false;
                    isCorrectUser = false;
                }
                else if (c == '\n'){
                    break;
                }
            }
        }catch (IOException e){
            System.out.println("Файл не найден");
        }
    }

    @Override
    public void save(User user) {
        try (RandomAccessFile reader = new RandomAccessFile(file,"rw")){
            reader.seek(reader.length());
            reader.writeChars(getRepresentString(user));
        }catch (IOException e){
            System.out.println("Файл не найден");
        }
    }

    @Override
    public User find(int id) {
        User user = null;
        try (RandomAccessFile reader = new RandomAccessFile(file,"rw")){
            StringBuilder builder = new StringBuilder();
            while (reader.getFilePointer() != reader.length()){
                char c = reader.readChar();
                if (c ==' '){
                    int idUser = Integer.parseInt(String.valueOf(reader.readChar()));
                    if (id == idUser){
                        reader.seek(reader.getFilePointer()-2L);
                        char c1;
                        while ((c1 = reader.readChar())!='\n'){
                            builder.append(c1);
                        }
                        return createUser(builder.toString());
                    }
                }
            }
        }catch (IOException e){
            System.out.println("Файл не найден");
        }
        return new User("null","null","null", -1);
    }

    @Override
    public void delete(int id) {
        try (RandomAccessFile reader = new RandomAccessFile(file,"rw")){
            boolean ouUser = false;
            boolean isCorrectUser = false;
            while (reader.length() > 0){
                char c = reader.readChar();
                if (c ==' '&&!ouUser){
                    ouUser = true;
                    int idFromRes = Integer.parseInt(String.valueOf(reader.readChar()));
                    if (idFromRes == id){
                        isCorrectUser = true;
                    }
                }
                if (c == '\n'&&!isCorrectUser){
                    ouUser = false;
                    isCorrectUser = false;
                }else if (c == '\n'&&isCorrectUser){
                    break;
                }
                if (ouUser&&isCorrectUser){
                    reader.seek(reader.getFilePointer()-2L);
                    reader.writeChars(" ");
                }
            }
        }catch (IOException e){
            System.out.println("Файл не найден");
        }
    }

    private User createUser(String represent) {
        String regex = ",";
        String[] fieldsValues = represent.replace(String.valueOf('\u0000'), "").split(regex);
        int id = Integer.parseInt(fieldsValues[0].trim());
        String name = fieldsValues[1].trim();
        String login = fieldsValues[2].trim();
        String password = fieldsValues[3].trim();
        return new User(name, login, password, id);
    }

    private String getRepresentString(User user) {
        return " "+user.getId()+","+user.getName()+","+user.getLogin()+","+user.getPassword()+"\n";
    }

    public void cleanFile(){
        file.delete();
    }

}
