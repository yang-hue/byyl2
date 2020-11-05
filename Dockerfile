FROM openjdk:12-alpine
# 向容器内复制文件
COPY ./* /app/
# 编译程序
WORKDIR /app/
RUN javac -d ./output ./program.java
# 将当前目录设为输出目录
WORKDIR /app/output