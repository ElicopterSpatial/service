package ro.unibuc.hello.controller;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

}