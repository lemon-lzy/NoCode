package com.lzy.nocode.service;

import com.lzy.nocode.model.dto.chathistory.ChatHistoryQueryRequest;
import com.lzy.nocode.model.entity.User;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.lzy.nocode.model.entity.ChatHistory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;

import java.time.LocalDateTime;

/**
 * 对话历史 服务层。
 *
 * @author lzy
 */
public interface ChatHistoryService extends IService<ChatHistory> {

    public boolean addChatMessage(Long appId, String message, String messageType, Long userId);

    public boolean deleteByAppId(Long appId);

    public QueryWrapper getQueryWrapper(ChatHistoryQueryRequest chatHistoryQueryRequest);

    public Page<ChatHistory> listAppChatHistoryByPage(Long appId, int pageSize,
                                                      LocalDateTime lastCreateTime,
                                                      User loginUser);

    public int loadChatHistoryToMemory(Long appId, MessageWindowChatMemory chatMemory, int maxCount);
}
