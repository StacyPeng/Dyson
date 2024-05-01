
//Auther：Hengqian Mao
package team11.Dyson.domian;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @Column(name = "staff_email_address")
    private String email;
    // ... 其他属性，如name, password, gender, birthday

    // 与课程的一对多关系
    @OneToMany(mappedBy = "teacher") // 'teacher' 必须与 Course 类中的 Staff 属性名匹配
    private Set<Course> coursesTaught;

    // getters 和 setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(Set<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    // 其他属性的getters和setters
}

