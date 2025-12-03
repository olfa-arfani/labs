FROM node:lts-alpine
WORKDIR /app
COPY DockerHandsOn/Exercice-Compose/app/package.json app/yarn.lock ./
COPY DockerHandsOn/Exercice-Compose/app/spec ./spec
COPY DockerHandsOn/Exercice-Compose/app/src ./src
RUN yarn install
CMD ["node", "src/index.js"]
EXPOSE 3000