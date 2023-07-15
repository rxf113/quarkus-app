FROM amazoncorretto:17.0.7-al2023-headless

ENV SERVICE_VERSION="1.0-SNAPSHOT-runner" \
    SERVICE_NAME='quarkus-app' \
    TZ="Asia/Shanghai"

# 设置时区
RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
# 创建工作目录
RUN mkdir /app
WORKDIR /app

# 复制 Jar 文件到容器
COPY ./target/${SERVICE_NAME}-${SERVICE_VERSION}.jar .

# 启动 Jar
CMD java -jar ${SERVICE_NAME}-${SERVICE_VERSION}.jar
