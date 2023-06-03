package kg.megalab.springbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
		/*
Проект «Идеи пользователей»
Есть юзеры с полями
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String login;
@Column(name = "email")
private String eMail;
@Column(name = "firstname")
private String firstName;
@Column(name = "lastname")
private String lastName;
@Column(name = "created_dt")
@CreationTimestamp
private LocalDateTime createdDt;
@Column(name = "birth_date")
private LocalDate birthDate;
Есть сущность Идеи от юзера. (Id, текст идеи, дата создания, id юзера)
Программа должна уметь сохранять, редактировать, получать и удалять юзеров.
Программа должна уметь сохранять идею от юзеров с привязкой к юзеру, редактировать
идеи, получать список идей по конкретному юзеру и удалять их.
Если удаляется юзер, то должны удалиться все его идеи.
Сообщения ошибок должны быть на двух языках (рус, англ)
Дополнительно - валидации:
Не могут быть пустыми : логин, почта, дата рождения, текст идеи
Должна быть валидация на почту, что это почта, дата рождения не может быть равна текущей или будущей дате,
текст идеи не должен превышать 200 символов, имя и фамилия минимум 3 символа, максимум 50,
логин минимум 5 символов - максимум 20.
		 */
	}

}
