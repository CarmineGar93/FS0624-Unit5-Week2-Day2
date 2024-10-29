package CarmineGargiulo.FS0624_Unit5_Week2_Day2.services;

import CarmineGargiulo.FS0624_Unit5_Week2_Day2.entities.Autore;
import CarmineGargiulo.FS0624_Unit5_Week2_Day2.exceptions.NotFoundException;
import CarmineGargiulo.FS0624_Unit5_Week2_Day2.payloads.AutorePayload;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AutoriService {
    private List<Autore> autoriList = new ArrayList<>();

    public List<Autore> findAll(){
        return autoriList;
    }

    public Autore saveAutore(AutorePayload body){
        Autore autore = new Autore(body.getNome(), body.getCognome(), body.getEmail());
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome());
        try{
            autore.setDataDiNascita(LocalDate.parse(body.getDataDiNascita()));
        } catch (Exception e) {
            autore.setDataDiNascita(LocalDate.of(1993, 2, 19));
        }
        autoriList.add(autore);
        return autore;

    }

    public Autore findAutoreById(int autoreId){
        if(autoriList.stream().noneMatch(autore -> autoreId == autore.getId())) throw new NotFoundException(autoreId);
        return autoriList.stream().filter(autore -> autoreId == autore.getId()).toList().getFirst();
    }

    public Autore findAutoreByIdAndUpdate(int autoreId, AutorePayload body){
        Autore autore = findAutoreById(autoreId);
        autore.setNome(body.getNome());
        autore.setCognome(body.getCognome());
        autore.setEmail(body.getEmail());
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome());
        try{
            autore.setDataDiNascita(LocalDate.parse(body.getDataDiNascita()));
        } catch (Exception e) {
            autore.setDataDiNascita(LocalDate.of(1993, 2, 19));
        }
        return autore;
    }

    public void findAutoreByIdAndDelete(int autoreId){
        Autore autore = findAutoreById(autoreId);
        autoriList.remove(autore);
    }
}
