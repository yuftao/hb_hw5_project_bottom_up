package hello;
// Generated 15-Sep-2017 10:55:10 by Hibernate Tools 5.2.3.Final


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Messages generated by hbm2java
 */
@Entity
@Table(name="MESSAGES"
    ,schema="PUBLIC"
    ,catalog="PUBLIC"
)
public class Messages  implements java.io.Serializable {


     private long messageId;
     private Messages messages;
     private String messageText;
     private Set messageses = new HashSet(0);

    public Messages() {
    }

	
    public Messages(long messageId) {
        this.messageId = messageId;
    }
    public Messages(long messageId, Messages messages, String messageText, Set messageses) {
       this.messageId = messageId;
       this.messages = messages;
       this.messageText = messageText;
       this.messageses = messageses;
    }
   
     @Id 

    
    @Column(name="MESSAGE_ID", unique=true, nullable=false)
    public long getMessageId() {
        return this.messageId;
    }
    
    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="NEXT_MESSAGE_ID")
    public Messages getMessages() {
        return this.messages;
    }
    
    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    
    @Column(name="MESSAGE_TEXT")
    public String getMessageText() {
        return this.messageText;
    }
    
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="messages")
    public Set getMessageses() {
        return this.messageses;
    }
    
    public void setMessageses(Set messageses) {
        this.messageses = messageses;
    }




}


