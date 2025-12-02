FROM node:lts-alpine
WORKDIR /app
COPY app/package.json app/yarn.lock ./
COPY app/src ./src
COPY app/spec ./spec
RUN yarn install
CMD ["node","src/index.js"]
EXPOSE 3000
