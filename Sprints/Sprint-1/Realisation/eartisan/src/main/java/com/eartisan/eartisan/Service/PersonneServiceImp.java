package com.eartisan.eartisan.Service;

import com.eartisan.eartisan.DAO.DomaineRepository;
import com.eartisan.eartisan.DAO.PersonneRepository;
import com.eartisan.eartisan.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/eartisan")
public class PersonneServiceImp implements IPersonneService {
    @Autowired
    private PersonneRepository personneRepository;

    @Override
    @RequestMapping(value = "/personnes",method = RequestMethod.GET)
    public List<Personne> getAll() {
        return personneRepository.findAll();
    }

    @Override
    @RequestMapping(value = "/getPersonne/{id}",method = RequestMethod.GET)
    public Personne getPersonne(@PathVariable("id") Long id) {
        return personneRepository.findOne(id);
    }

    @Override
    @RequestMapping(value = "/addPersonne",method = RequestMethod.POST)
    public Personne addPersonne(@RequestBody Personne personne) {
        System.out.println(personne.getEmail());
        Personne personne1=personneRepository.save(personne);

        //String url="http://localhost:8080/eartisan/confPersonne/";
        String url="http://localhost:4200/eartisan/infoArtison/";
        if(personne1.getId_personne()!=null)
        {
            sendMail(personne1.getEmail(),"confirmation d'email",url+personne1.getId_personne());
        }

        return personne1;
    }

    @Override
    @RequestMapping(value = "/updatePersonne",method = RequestMethod.PUT)
    public Personne updatePersonne(@RequestBody Personne personne) {
        return personneRepository.saveAndFlush(personne);
    }

    @Override
    @RequestMapping(value = "/deletePersonne/{id}",method = RequestMethod.DELETE)
    public void deletePersonne(@PathVariable("id") Long id) {
        personneRepository.delete(id);
    }
    @RequestMapping(value = "/confPersonne/{id}",method = RequestMethod.GET)
    public Personne confPersonne(@PathVariable("id") Long id)
    {
        // personneRepository.updateEtat(id);
         return null;
    }
    public boolean sendMail(String to,String subject,String messageText)
    {
        try {
            String host="smtp.gmail.com";
            String user="maarir.mohammad1@gmail.com";
            String pass="29121993";
            String from="maarir.mohammad1@gmail.com";
            boolean sessionDebug=false;
            Properties props=System.getProperties();
            props.put("mail.smtp.starttls.enable","true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailsession=Session.getDefaultInstance(props, null);
            mailsession.setDebug(sessionDebug);
            Message msg=new MimeMessage(mailsession);

            msg.setFrom(new InternetAddress(from));

            InternetAddress[] address={new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);
            Transport transport=mailsession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("dane");
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }

    }

}
