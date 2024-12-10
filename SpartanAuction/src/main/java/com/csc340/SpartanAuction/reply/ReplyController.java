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
        return "redirect:/users/profile";
    }

    @PostMapping("/update/{id}")
    public String updateReply(@PathVariable int id, @RequestBody Reply reply) {
        replyService.updateReply(id, reply);
        return "redirect:/users/profile";
    }

    @GetMapping("/delete/{id}")
    public String deleteReplyById(@PathVariable int id) {
        replyService.deleteReplyById(id);
        return "redirect:/users/profile";
    }
}
