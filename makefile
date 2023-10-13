# Makefile

DC_COMP_DEV:= docker/docker-compose-dev.yml
DC_COMP_PROD:= docker/docker-compose.yml

dev-up:
	docker-compose -f $(DC_COMP_DEV) up -d

dev-down:
	docker-compose -f $(DC_COMP_DEV) down

dev-logs:
	docker-compose -f $(DC_COMP_DEV) logs -f

dev-build:
	docker-compose -f $(DC_COMP_DEV) build

dev-clean-volumes:
	docker-compose -f $(DC_COMP_DEV) down -v

dev-psql:
	docker-compose -f $(DC_COMP_DEV) exec postgres psql -U nidz nidz
