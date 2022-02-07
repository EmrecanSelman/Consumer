package com.consumer.Consumer.Repo;

import com.consumer.Consumer.Model.Consumer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ConsumerRepo extends JpaRepository<Consumer,Integer> {

   boolean   existsConsumerByNameAndPassAndMail(String name, String pass, String mail);
    @Transactional
    @Modifying
   @Query("DELETE FROM Consumer WHERE name =?1 and pass =?2 and mail =?3 ")
    void deleteConsumerByMailAndNameAndPass( String name, String pass, String mail);
    @Modifying
    @Transactional
    @Query("UPDATE  Consumer SET  name =?1 , pass =?2 , mail =?3 Where mail=?4")
    void updateConsumer(String name, String pass, String mail ,String oldMail);


}
