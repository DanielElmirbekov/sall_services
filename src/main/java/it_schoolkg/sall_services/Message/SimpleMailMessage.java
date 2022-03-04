package it_schoolkg.sall_services.Message;

public interface SimpleMailMessage {
    void setFrom(String s);

    void setTo(String to);

    void setSubject(String код_потверждения);

    void setText(String s);
}
