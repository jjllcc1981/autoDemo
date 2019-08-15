package autointerface.demo.mybatis.entity;

import java.sql.Timestamp;

public class MockDataInfo {
    private Integer id;

    private Integer businessId;

    private String businessPath;

    private String businessMethod;

    private String businessInterfaceDetail;

    private String businessRequestHashcode;

    private Integer status;

    private Timestamp createTime;

    private String createUser;

    private Timestamp updateTime;

    private String updateUser;

    private String businessRequest;

    private String businessResponse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getBusinessPath() {
        return businessPath;
    }

    public void setBusinessPath(String businessPath) {
        this.businessPath = businessPath == null ? null : businessPath.trim();
    }

    public String getBusinessMethod() {
        return businessMethod;
    }

    public void setBusinessMethod(String businessMethod) {
        this.businessMethod = businessMethod == null ? null : businessMethod.trim();
    }

    public String getBusinessInterfaceDetail() {
        return businessInterfaceDetail;
    }

    public void setBusinessInterfaceDetail(String businessInterfaceDetail) {
        this.businessInterfaceDetail = businessInterfaceDetail == null ? null : businessInterfaceDetail.trim();
    }

    public String getBusinessRequestHashcode() {
        return businessRequestHashcode;
    }

    public void setBusinessRequestHashcode(String businessRequestHashcode) {
        this.businessRequestHashcode = businessRequestHashcode == null ? null : businessRequestHashcode.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getBusinessRequest() {
        return businessRequest;
    }

    public void setBusinessRequest(String businessRequest) {
        this.businessRequest = businessRequest == null ? null : businessRequest.trim();
    }

    public String getBusinessResponse() {
        return businessResponse;
    }

    public void setBusinessResponse(String businessResponse) {
        this.businessResponse = businessResponse == null ? null : businessResponse.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", businessId=").append(businessId);
        sb.append(", businessPath=").append(businessPath);
        sb.append(", businessMethod=").append(businessMethod);
        sb.append(", businessInterfaceDetail=").append(businessInterfaceDetail);
        sb.append(", businessRequestHashcode=").append(businessRequestHashcode);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", businessRequest=").append(businessRequest);
        sb.append(", businessResponse=").append(businessResponse);
        sb.append("]");
        return sb.toString();
    }
}