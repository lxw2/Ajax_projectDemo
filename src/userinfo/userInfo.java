package userinfo;

public class userInfo {
    private String name;
    private String birthday;
    private String sex;
    private String statue;

    public userInfo() {
    }

    @Override
    public String toString() {
        return "userInfo{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex='" + sex + '\'' +
                ", statue='" + statue + '\'' +
                '}';
    }

    public userInfo(String name, String birthday, String sex, String statue) {
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.statue = statue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }
}
