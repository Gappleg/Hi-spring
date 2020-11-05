package Hi.Hispring.domain;

public class Member {
    // id 이름 식별기능 요구사항
    private Long id; // system이 저장하는 id
    private String name; // 고객이 회원가입 시 적는 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
