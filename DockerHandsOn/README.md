# Installation guide

## Prerequisites
- A Linux system with systemd (instructions below assume systemd).
- Local user account (commands use `$USER`).

## 1. Verify Docker is installed and service is running
Check Docker binary and service:
```bash
docker --version
sudo systemctl status docker
```
If Docker is not installed, follow your distribution's package instructions (or use Docker's official docs).

To enable and start the service:
```bash
sudo systemctl enable --now docker
```

## 2. Add a `docker` group and add your user (avoid running Docker as root)
Create the group if it doesn't exist and add your user:
```bash
sudo groupadd -f docker
sudo usermod -aG docker $USER
```
Apply the new group membership (log out and log back in, or run):
```bash
newgrp docker
```

## 3. Optional: Rootless mode
For running both containers and the daemon without root privileges, see Docker Rootless mode:
https://docs.docker.com/engine/security/rootless/

## 4. Quick step-by-step exercises (quick wins)
1. Verify you can run containers without sudo:
```bash
docker run --rm hello-world
```
2. List running containers:
```bash
docker ps
```
3. Pull and run a lightweight test shell:
```bash
docker run --rm -it alpine sh
```

Follow these steps step-by-step to get quick, verifiable wins.

4. Clone repo :clone https://github.com/docker/getting-started-app
4. 1. cd getting-started-app
4. 2. Create Dockerfile same /Exercice1/Dockerfile
4. 3. docker build -t getting-started .
4. 4. docker run -d --name getting-started -p 3000:3000 getting-started


5. Clone repo https://github.com/olfa-arfani/awesome-compose
5. 1. Exercice : Sample Image Build