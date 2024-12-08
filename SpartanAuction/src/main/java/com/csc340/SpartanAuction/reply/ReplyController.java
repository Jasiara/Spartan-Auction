package com.csc340.SpartanAuction.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/replies")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @GetMapping("/all")
    public List<Reply> getAllReplies() {return replyService.getAllReplies();}

    @GetMapping("/review/{reviewId}")
    public List<Reply> getAllRepliesForOneReview(@PathVariable int reviewId) {
        return replyService.getAllRepliesForOneReview(reviewId);
    }

    @GetMapping("/{id}")
    public Reply getOneReply(@PathVariable int id) {
        return replyService.getReplyById(id);
    }

    @PostMapping("/new/{userId}")
    public String addNewReply(@ModelAttribute("reply") Reply reply, @PathVariable int userId) {
        replyService.addNewReply(reply);
        System.out.println(reply.toString());
        System.out.println(reply.getReview().getProviderUser().getId());
        return "redirect:/users/profile/" + userId;
    }

    @PutMapping("/update/{id}")
    public Reply updateReply(@PathVariable int id, @RequestBody Reply reply) {
        replyService.updateReply(id, reply);
        return replyService.getReplyById(id);
    }

    @DeleteMapping("/delete/{id}")
    public List<Reply> deleteReplyById(@PathVariable int id) {
        replyService.deleteReplyById(id);
        return replyService.getAllReplies();
    }
}
