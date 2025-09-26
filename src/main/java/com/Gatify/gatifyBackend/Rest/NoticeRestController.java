package com.Gatify.gatifyBackend.Rest;

import com.Gatify.gatifyBackend.Entity.Notice;
import com.Gatify.gatifyBackend.Service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notices")
public class NoticeRestController {

    private final NoticeService noticeService;

    @Autowired
    public NoticeRestController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping
    public List<Notice> findAll() {
        return noticeService.findAll();
    }

    @GetMapping("/{noticeId}")
    public Notice getNotice(@PathVariable int noticeId) {
        Notice notice = noticeService.findById(noticeId);
        if (notice == null) {
            throw new RuntimeException("Notice id not found - " + noticeId);
        }
        return notice;
    }

    @PostMapping
    public Notice addNotice(@RequestBody Notice notice) {
        notice.setId(0); // Force save of new item
        return noticeService.save(notice);
    }

    @PutMapping
    public Notice updateNotice(@RequestBody Notice notice) {
        return noticeService.save(notice);
    }

    @DeleteMapping("/{noticeId}")
    public String deleteNotice(@PathVariable int noticeId) {
        Notice notice = noticeService.findById(noticeId);
        if (notice == null) {
            throw new RuntimeException("Notice id not found - " + noticeId);
        }
        noticeService.deleteById(noticeId);
        return "Deleted notice id - " + noticeId;
    }
}
