FROM node:lts-alpine
WORKDIR /app
COPY app/package.json app/yarn.lock ./
COPY app/spec ./spec
COPY app/src ./src
RUN yarn install
CMD ["node", "src/index.js"]
EXPOSE 3000