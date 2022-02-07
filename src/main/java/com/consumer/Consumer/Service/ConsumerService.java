package com.consumer.Consumer.Service;

import com.consumer.Consumer.Exception.ResourceNotFoundException;
import com.consumer.Consumer.Model.Consumer;
import com.consumer.Consumer.Repo.ConsumerRepo;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsumerService implements IService{

    private final ConsumerRepo consumerRepo;

    @Override
    public Consumer saveConsumer(Consumer consumer) {
        return consumerRepo.save(consumer);
    }

    @Override
    public List<Consumer> getAllConsumer() {
        return consumerRepo.findAll();
    }

    @Override
    public Consumer getConsumer(int id) {
        Optional<Consumer> user = consumerRepo.findById(id);
        if (user.isPresent()){
            return user.get();
        }
        else
            throw new ResourceNotFoundException("User","id",id);

    }

    @Override
    public Consumer updateConsumer(Consumer consumer, int id) {
        Consumer isExistUser = consumerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id) );

        isExistUser.setName(consumer.getName());
        isExistUser.setPass(consumer.getPass());
        consumerRepo.save(isExistUser);

        return isExistUser;
    }

    @Override
    public void deleteConsumer1(int id) {
        consumerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id) );
        consumerRepo.deleteById(id);
    }



    @Override
    public boolean isValid(String name, String pass, String mail) {
        return consumerRepo.existsConsumerByNameAndPassAndMail(name, pass, mail);
    }

    @Override
    public void deleteConsumer(String name, String pass, String mail) {


         consumerRepo.deleteConsumerByMailAndNameAndPass(name, pass, mail);
    }

    @Override
    public void updateConsumer(String name, String pass, String mail,String oldMail) {
        consumerRepo.updateConsumer(name, pass, mail,oldMail);
    }


}
