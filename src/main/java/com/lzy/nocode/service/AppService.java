package com.lzy.nocode.service;

import com.lzy.nocode.model.dto.app.AppQueryRequest;
import com.lzy.nocode.model.entity.User;
import com.lzy.nocode.model.vo.AppVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.lzy.nocode.model.entity.App;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author lzy
 */
public interface AppService extends IService<App> {

    /**
     * App->appVo
     * @param app
     * @return
     */
    public AppVO getAppVO(App app);

    /**
     * 构建app查询相关的queryWrapper
     * @param appQueryRequest
     * @return
     */
    public QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    /**
     * List<App>->List<AppVO>(因为AppVO有携带用户信息所以需要连表查询)
     * @param appList
     * @return
     */
    public List<AppVO> getAppVOList(List<App> appList);

    /**
     * ai生成应用接口
     * @param appId
     * @param message 用户消息
     * @param loginUser 登录用户
     * @return
     */
    public Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    /**
     *应用部署接口
     * @param appId
     * @param loginUser
     * @return
     */
    public String deployApp(Long appId, User loginUser);

    /**
     * 异步生成应用截图并更新封面
     *
     * @param appId  应用ID
     * @param appUrl 应用访问URL
     */
    public void generateAppScreenshotAsync(Long appId, String appUrl);
}
