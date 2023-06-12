package ro.unibuc.hello.controller;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.unibuc.hello.data.PlayerEntity;
import ro.unibuc.hello.data.PlayerRepository;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping("/player/create")
    @ResponseBody
    public PlayerEntity createPlayer(@RequestParam(name="nume") String nume, @RequestParam(name="echipa") String echipa, @RequestParam(name="pozitie") String pozitie) {
        return playerRepository.save(new PlayerEntity(nume, echipa, pozitie));
    }
    @GetMapping("/player/getAll")
    @ResponseBody
    public List<PlayerEntity> getPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/player/get")
    @ResponseBody
    public PlayerEntity getPlayer(@RequestParam(name="id") String id) {
        return playerRepository.findById(String.valueOf(new ObjectId(id))).orElse(null);
    }

    @DeleteMapping("/player/delete")
    @ResponseBody
    public void deletePlayer(@RequestParam(name="id") String id) {
        playerRepository.deleteById(String.valueOf(new ObjectId(id)));
    }

    @PutMapping("/player/edit")
    @ResponseBody
    public PlayerEntity editPlayer(@RequestParam(name="id") String id, @RequestParam(name="nume") String nume, @RequestParam(name="echipa") String echipa, @RequestParam(name="pozitie") String pozitie) {
        PlayerEntity player = playerRepository.findById(String.valueOf(new ObjectId(id))).orElse(null);
        if(player != null) {
            if(nume != null)
                player.setNume(nume);
            if(echipa != null)
                player.setEchipa(echipa);
            if(pozitie != null)
                player.setPozitie(pozitie);
            return playerRepository.save(player);
        } else
            return  null;
    }

}