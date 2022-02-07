package com.consumer.Consumer.Controller;

import com.consumer.Consumer.Exception.ResourceNotFoundException;
import com.consumer.Consumer.Model.Consumer;
import com.consumer.Consumer.Service.ConsumerService;
import com.consumer.Consumer.Util.ServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class ConsumerController {

    private final ConsumerService consumerService;

    @RequestMapping(value = "saveUser", method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Consumer> saveConsumer(Consumer consumer) {
        if (consumer == null) {
            throw new ResourceNotFoundException();
        } else {
            return new ResponseEntity<>(consumerService.saveConsumer(consumer), HttpStatus.CREATED);
        }
    }
    @GetMapping("search")
    public List<Consumer> getAllUser() {
        return consumerService.getAllConsumer();
    }

    @GetMapping("login")
    public boolean login(HttpServletRequest request) {
        String name = ServiceUtil.getParameter(request, "name", "error");
        String password = ServiceUtil.getParameter(request, "pass", "error");
        String mail = ServiceUtil.getParameter(request, "mail", "error");
        if (name.equals("error") || password.equals("error") ||  mail.equals("error")) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "name ,password veya mail  gödnermen lazım");
        } else {
          return  consumerService.isValid(name,password,mail);
        }

    }


    @GetMapping("/{id}")
    public ResponseEntity<Consumer> getUserbyID(@PathVariable("id") int id) {
        return new ResponseEntity<>(consumerService.getConsumer(id), HttpStatus.OK);
    }

    @PutMapping("{name}/{pass}/{mail}")
    public void updateUser(@PathVariable("name") String name,@PathVariable("pass") String pass,@PathVariable("mail") String mail,String oldMail) {
         consumerService.updateConsumer( name,pass,mail,oldMail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        consumerService.deleteConsumer1(id);
        return new ResponseEntity<>("Deleted succesfuly", HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public void deleteConsumerByMailAndNameAndPass(HttpServletRequest request) {
        String name = ServiceUtil.getParameter(request, "name", "error");
        String password = ServiceUtil.getParameter(request, "pass", "error");
        String mail = ServiceUtil.getParameter(request, "mail", "error");
        if (name.equals("error") || password.equals("error") || mail.equals("error")) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "name ,password veya mail  gödnermen lazım");
        } else {

            consumerService.deleteConsumer(name, password, mail);
        }
        }
}
