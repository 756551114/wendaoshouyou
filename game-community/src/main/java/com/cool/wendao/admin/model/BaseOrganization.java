package com.cool.wendao.admin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_base_organization")
public class BaseOrganization implements Serializable {


    /**
     * 商户后台登陆账号
     */
    @Transient
    private String loginName;

    /**
     * 提交类型
     * submitType == 1 小微商户进件
     * submitType == 2 小微商户升级
     */
    @Transient
    private String submitType;

    /**
     * 是否提交审核1-提交审核
     */
    @Transient
    private Integer isSubmitCheck;


    @Transient
    private String busiTypeName;


    /**
     * 机构id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 上级机构id
     */
    private String parentOrgId;

    /**
     * 机构类型  1-运营商  2-分销商 3-商户 4-子商户
     */
    private Integer orgType;

    /**
     * 微信审核结果  0 小微商户待进件  1小微商户进件中 2 小微商户进件成功待签约
     * 3小微商户进件成功待升级  4 小微商户升级中  5小微商户账户待验证  6小微商户待签约  7 小微商户完成
     * 8进件失败  9升级失败
     */
    private Integer weChatResult;

    /**
     * 业务类型
     */
    private Integer busiTypeId;

    /**
     * 业务子类型
     */
    private Integer busiSubTypeId;

    /**
     * 机构编号
     */
    private String orgCode;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 商户邮政编码
     */
    private String storeAddressCode;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 身份证姓名
     */
    private String idCardName;

    /**
     * 身份证号码
     */
    private String idCardId;

    /**
     * 身份证有效期
     */
    private String idCardValidTime;

    /**
     * 联系电话
     */
    private String contactTel;

    /**
     * 省
     */
    private Integer province;

    /**
     * 市
     */
    private Integer city;

    /**
     * 排序
     */
    private Integer seq;

    /**
     * 区
     */
    private Integer district;

    /**
     * 机构地址
     */
    private String orgAddress;

    /**
     * 机构纬度
     */
    private BigDecimal latitude;

    /**
     * 机构经度
     */
    private BigDecimal longitude;

    /**
     * 行业
     */
    private String busiInfo;

    /**
     * 营业时间
     */
    private String busiTime;

    /**
     * 客服电话
     */
    private String clientTel;

    /**
     * 机构logo图片地址
     */
    private String logoUrl;

    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * 缩略图地址
     */
    private String thumbUrl;

    /**
     * 机构简介
     */
    private String orgIntro;

    /**
     * 机构介绍内容
     */
    private String orgContent;

    /**
     * 经营者姓名
     */
    private String operatorName;

    /**
     * 经营者手机号码
     */
    private String operatorTel;

    /**
     * 认证类型   1-个人 2-企业 3-个体工商户
     */
    private Integer authType;

    /**
     * 企业所在地
     */
    private String compAddress;

    /**
     * 公司名称
     */
    private String compName;

    /**
     * 公司法人
     */
    private String compLegalPerson;

    /**
     * 公司联系人姓名
     */
    private String compContactName;

    /**
     * 公司联系人电话
     */
    private String compContactTel;

    /**
     * 推荐指数
     */
    private BigDecimal busiRank;

    /**
     * 经营类型
     */
    private String busiCategory;

    /**
     * 经营范围
     */
    private String busiAptitude;

    /**
     * 营业执照图片地址
     */
    private String busiLicenseUrl;

    /**
     * 组织机构代码证图片地址
     */
    private String orgCodeCertUrl;

    /**
     * 银行开户证明图片地址
     */
    private String bankOpenAccCertUrl;

    /**
     * 法人身份证正面图片地址
     */
    //lp_id_num_front_url
    private String lpIdNumFrontUrl;

    /**
     * 法人身份证反面图片地址
     */
    private String lpIdNumReverseUrl;

    /**
     * 其他资质图片地址
     */
    private String otherAptitude;


    /**
     * 开户所在省份id
     */
    private Integer accProvinceId;

    /**
     * 开户所在城市id
     */
    private Integer accCityId;

    /**
     * 开户所在行政区id
     */
    private Integer accDistrictId;

    /**
     * 开户银行地址
     */
    private String accBankAddr;

    /**
     * 开户银行
     */
    private String accBankCode;

    /**
     * 开户人
     */
    private String accBankHolder;

    /**
     * 开户银行账号
     */
    private String accBankNo;

    /**
     * 开户银行省市编码
     */
    private String bankAddressCode;


    /**
     * 是否完善信息  0-否  1-是
     */
    private Integer isPerfect;

    /**
     * 是否可以售卖商品  0-否  1-是
     */
    private Integer isSale;

    /**
     * 是否认证信息  0-待提审 1-待审核 2-审核不通过  3-审核通过
     */
    private Integer isCheck;

    /**
     * 当前状态  0-已删除 1-正常  2-冻结
     */
    private Integer curStatus;

    /**
     * 支付二维码
     */
    private String payEwmUrl;

    /**
     * 视频封面地址
     */
    private String videoCoverUrl;

    /**
     * 视频路径
     */
    private String videoUrl;

    /**
     * 背景图片
     */
    private String bgImageUrl;

    /**
     * 最低价格(分)
     */
    private Integer minPrice;

    /**
     * 排序时间，默认填入新增时间，点击置顶需要更新该时间
     */
    private Date sortTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 新增时间
     */
    private Date addTime;

    /**
     * 关键词
     */
    private String keywords;

    /**
     * 统一信用代码
     */
    private String creditCode;

    /**
     * 是否存在子商户  0-不存在  1-存在
     */
    private Integer isExistChild;

    /**
     * 是否是特色商铺  0-不是  1-是
     */
    private Integer isSpecialty;

    /**
     * 私钥
     */
    private String privateKey;

    /**
     * 商户经理ID
     */
    private String managerId;

    /**
     * 2-企业   4-个体工商户
     * 3-党政、机关及事业单位  1708-其他组织
     */
    private Integer organizationType;

    /**
     * 营业执照扫描件
     */
    private String businessLicenseCopy;

    /**
     * 营业执照注册号
     */
    private String businessLicenseNumber;

    /**
     * 营业期限
     */
    private String businessTime;


    /**
     * 营业执照类型
     * 1762-已三证合一    1763-未三证合一
     * 若营业执照上的营业执照注册号为18位统一社会信用代码，请选择“已三证合一”，否则请选择“未三证合一”
     */
    private Integer businessLicenceType;

    /**
     * 组织机构代码证复印件
     * 主体类型为企业/党政、机关及事业单位/其他组织 且 营业执照为未三证合一，必填
     */
    private String organizationCopy;

    /**
     * 组织机构代码
     * 请填写组织机构代码证上的组织机构代码
     * 9或10位 数字|字母|连字符
     * 主体类型为企业/党政、机关及事业单位/其他组织 且 营业执照为未三证合一，必填
     */
    private String organizationNumber;
    /**
     * 组织机构代码有效期限
     * 请填写组织机构代码证上的组织机构代码有效期
     * 注意参照示例中的格式
     * 结束时间需大于开始时间
     * 有效期必须大于60天
     * 主体类型为企业/党政、机关及事业单位/其他组织 且 营业执照为未三证合一，必填
     */
    private String organizationTime;


    /**
     * 开户名称
     *
     * @return
     */
    private String accountName;
    /**
     * 开户银行
     */
    private String accountBank;

    /**
     * 开户银行省市编码
     */
    private String upBankAddressCode;

    /**
     * 开户银行全称
     */
    private String bankName;

    /**
     * 银行卡号
     */
    private String accountNumber;


    /**
     * 小微商户进件成功后返回的商户id
     */
    private String subMchId;


    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getBusinessLicenseCopy() {
        return businessLicenseCopy;
    }

    public void setBusinessLicenseCopy(String businessLicenseCopy) {
        this.businessLicenseCopy = businessLicenseCopy;
    }

    public String getBusinessLicenseNumber() {
        return businessLicenseNumber;
    }

    public void setBusinessLicenseNumber(String businessLicenseNumber) {
        this.businessLicenseNumber = businessLicenseNumber;
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
    }

    public Integer getBusinessLicenceType() {
        return businessLicenceType;
    }

    public void setBusinessLicenceType(Integer businessLicenceType) {
        this.businessLicenceType = businessLicenceType;
    }

    public String getOrganizationCopy() {
        return organizationCopy;
    }

    public void setOrganizationCopy(String organizationCopy) {
        this.organizationCopy = organizationCopy;
    }

    public String getOrganizationNumber() {
        return organizationNumber;
    }

    public void setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
    }

    public String getOrganizationTime() {
        return organizationTime;
    }

    public void setOrganizationTime(String organizationTime) {
        this.organizationTime = organizationTime;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getUpBankAddressCode() {
        return upBankAddressCode;
    }

    public void setUpBankAddressCode(String upBankAddressCode) {
        this.upBankAddressCode = upBankAddressCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(Integer organizationType) {
        this.organizationType = organizationType;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }


    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    public Integer getBusiTypeId() {
        return busiTypeId;
    }

    public void setBusiTypeId(Integer busiTypeId) {
        this.busiTypeId = busiTypeId;
    }

    public Integer getBusiSubTypeId() {
        return busiSubTypeId;
    }

    public void setBusiSubTypeId(Integer busiSubTypeId) {
        this.busiSubTypeId = busiSubTypeId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getLinkman() {
        return linkman;
    }

    public String getBankAddressCode() {
        return bankAddressCode;
    }

    public void setBankAddressCode(String bankAddressCode) {
        this.bankAddressCode = bankAddressCode;
    }

    public Integer getWeChatResult() {
        return weChatResult;
    }

    public void setWeChatResult(Integer weChatResult) {
        this.weChatResult = weChatResult;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getBusiInfo() {
        return busiInfo;
    }

    public void setBusiInfo(String busiInfo) {
        this.busiInfo = busiInfo;
    }

    public String getBusiTime() {
        return busiTime;
    }

    public void setBusiTime(String busiTime) {
        this.busiTime = busiTime;
    }

    public String getClientTel() {
        return clientTel;
    }

    public void setClientTel(String clientTel) {
        this.clientTel = clientTel;
    }

    public String getStoreAddressCode() {
        return storeAddressCode;
    }

    public void setStoreAddressCode(String storeAddressCode) {
        this.storeAddressCode = storeAddressCode;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getOrgIntro() {
        return orgIntro;
    }

    public void setOrgIntro(String orgIntro) {
        this.orgIntro = orgIntro;
    }

    public String getOrgContent() {
        return orgContent;
    }

    public void setOrgContent(String orgContent) {
        this.orgContent = orgContent;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorTel() {
        return operatorTel;
    }

    public void setOperatorTel(String operatorTel) {
        this.operatorTel = operatorTel;
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public String getCompAddress() {
        return compAddress;
    }

    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompLegalPerson() {
        return compLegalPerson;
    }

    public void setCompLegalPerson(String compLegalPerson) {
        this.compLegalPerson = compLegalPerson;
    }

    public String getCompContactName() {
        return compContactName;
    }

    public void setCompContactName(String compContactName) {
        this.compContactName = compContactName;
    }

    public String getCompContactTel() {
        return compContactTel;
    }

    public void setCompContactTel(String compContactTel) {
        this.compContactTel = compContactTel;
    }

    public BigDecimal getBusiRank() {
        return busiRank;
    }

    public void setBusiRank(BigDecimal busiRank) {
        this.busiRank = busiRank;
    }

    public String getBusiCategory() {
        return busiCategory;
    }

    public void setBusiCategory(String busiCategory) {
        this.busiCategory = busiCategory;
    }

    public String getBusiAptitude() {
        return busiAptitude;
    }

    public void setBusiAptitude(String busiAptitude) {
        this.busiAptitude = busiAptitude;
    }

    public String getBusiLicenseUrl() {
        return busiLicenseUrl;
    }

    public void setBusiLicenseUrl(String busiLicenseUrl) {
        this.busiLicenseUrl = busiLicenseUrl;
    }

    public String getOrgCodeCertUrl() {
        return orgCodeCertUrl;
    }

    public void setOrgCodeCertUrl(String orgCodeCertUrl) {
        this.orgCodeCertUrl = orgCodeCertUrl;
    }

    public String getBankOpenAccCertUrl() {
        return bankOpenAccCertUrl;
    }

    public void setBankOpenAccCertUrl(String bankOpenAccCertUrl) {
        this.bankOpenAccCertUrl = bankOpenAccCertUrl;
    }

    public String getLpIdNumFrontUrl() {
        return lpIdNumFrontUrl;
    }

    public void setLpIdNumFrontUrl(String lpIdNumFrontUrl) {
        this.lpIdNumFrontUrl = lpIdNumFrontUrl;
    }

    public String getLpIdNumReverseUrl() {
        return lpIdNumReverseUrl;
    }

    public void setLpIdNumReverseUrl(String lpIdNumReverseUrl) {
        this.lpIdNumReverseUrl = lpIdNumReverseUrl;
    }

    public String getOtherAptitude() {
        return otherAptitude;
    }

    public void setOtherAptitude(String otherAptitude) {
        this.otherAptitude = otherAptitude;
    }

    public Integer getAccProvinceId() {
        return accProvinceId;
    }

    public void setAccProvinceId(Integer accProvinceId) {
        this.accProvinceId = accProvinceId;
    }

    public Integer getAccCityId() {
        return accCityId;
    }

    public void setAccCityId(Integer accCityId) {
        this.accCityId = accCityId;
    }

    public Integer getAccDistrictId() {
        return accDistrictId;
    }

    public void setAccDistrictId(Integer accDistrictId) {
        this.accDistrictId = accDistrictId;
    }

    public String getAccBankAddr() {
        return accBankAddr;
    }

    public void setAccBankAddr(String accBankAddr) {
        this.accBankAddr = accBankAddr;
    }

    public String getAccBankCode() {
        return accBankCode;
    }

    public void setAccBankCode(String accBankCode) {
        this.accBankCode = accBankCode;
    }

    public String getAccBankHolder() {
        return accBankHolder;
    }

    public void setAccBankHolder(String accBankHolder) {
        this.accBankHolder = accBankHolder;
    }

    public String getAccBankNo() {
        return accBankNo;
    }

    public void setAccBankNo(String accBankNo) {
        this.accBankNo = accBankNo;
    }

    public Integer getIsPerfect() {
        return isPerfect;
    }

    public void setIsPerfect(Integer isPerfect) {
        this.isPerfect = isPerfect;
    }

    public Integer getIsSale() {
        return isSale;
    }

    public void setIsSale(Integer isSale) {
        this.isSale = isSale;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public Integer getCurStatus() {
        return curStatus;
    }

    public void setCurStatus(Integer curStatus) {
        this.curStatus = curStatus;
    }

    public String getPayEwmUrl() {
        return payEwmUrl;
    }

    public void setPayEwmUrl(String payEwmUrl) {
        this.payEwmUrl = payEwmUrl;
    }

    public String getVideoCoverUrl() {
        return videoCoverUrl;
    }

    public void setVideoCoverUrl(String videoCoverUrl) {
        this.videoCoverUrl = videoCoverUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        if (videoUrl != null && videoUrl.trim().length() > 0) {
            this.videoUrl = videoUrl.trim();
        }
    }

    public String getBgImageUrl() {
        return bgImageUrl;
    }

    public void setBgImageUrl(String bgImageUrl) {
        this.bgImageUrl = bgImageUrl;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Date getSortTime() {
        return sortTime;
    }

    public void setSortTime(Date sortTime) {
        this.sortTime = sortTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public Integer getIsExistChild() {
        return isExistChild;
    }

    public void setIsExistChild(Integer isExistChild) {
        this.isExistChild = isExistChild;
    }

    public Integer getIsSpecialty() {
        return isSpecialty;
    }

    public void setIsSpecialty(Integer isSpecialty) {
        this.isSpecialty = isSpecialty;
    }

    public String getIdCardValidTime() {
        return idCardValidTime;
    }

    public void setIdCardValidTime(String idCardValidTime) {
        this.idCardValidTime = idCardValidTime;
    }

    public String getIdCardName() {
        return idCardName;
    }

    public void setIdCardName(String idCardName) {
        this.idCardName = idCardName;
    }

    public String getIdCardId() {
        return idCardId;
    }

    public void setIdCardId(String idCardId) {
        this.idCardId = idCardId;
    }

    public String getBusiTypeName() {
        return busiTypeName;
    }

    public void setBusiTypeName(String busiTypeName) {
        this.busiTypeName = busiTypeName;
    }

    public Integer getIsSubmitCheck() {
        return isSubmitCheck;
    }

    public void setIsSubmitCheck(Integer isSubmitCheck) {
        this.isSubmitCheck = isSubmitCheck;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getSubmitType() {
        return submitType;
    }

    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}