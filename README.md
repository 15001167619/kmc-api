# kmc-api 服务

## 一、服务启动顺序
### api-eureka(注册中心)--> api-config(配置中心)--> api-admin(应用监控)
### -->api-producer(API服务对外提供者)-->api-rest(API服务消费者)
### -->api-turbine(API服务消费者的熔断监控Dashboard展示)
### -->api-gateway(路由网关)

## 二、接口服务访问路径示例

### 获取Token (http://localhost:6088/api/auth/authorize/getAccessToken?userType=1&mobile=15001167619)
### 安全接口 (http://localhost:6088/api/doctor/auth/user/getUserInfo?id=3&token=222&sign=333)
### 普通接口 (http://localhost:6088/api/doctor/user/getUserInfo?id=100)

## 三、服务程序监控访问路径

### admin 应用程序监控 (http://localhost:8000/#/applications)

## 四、配置中心 消息总线

### 4.1 客户端(如 api-producer) 修改配置,在 kmc-config 工程中 api-server-producer-dev.yml 修改配置后,手动刷新

### 4.2 刷新步骤----> 在postman中执行 POST请求更新配置文件 (http://localhost:6089/actuator/bus-refresh)

### eg: http://localhost:6089/getSpecialValidatorValue(访问前 true),更新配置文件后, 执行4.2,再次访问 false



