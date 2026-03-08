# Manaus Routing System 📍

Sistema de roteamento geográfico focado na cidade de Manaus, desenvolvido para fins de praticar a implementação de algoritmos de grafos em alta performance e aplicar boas práticas de Engenharia de Software.

🚧 **Status:** Em desenvolvimento ativo (Work in Progress)

## 🚀 Diferenciais Técnicos
- **Algoritmo:** Implementação customizada de Dijkstra para busca de caminhos mínimos.
- **GIS (Geographic Information System):** Cálculo de distâncias utilizando a Fórmula de Haversine (assumindo a Terra como uma esfera perfeita).
- **Arquitetura:** Design rigorosamente orientado a objetos, seguindo princípios de Clean Architecture e Domain-Driven Design (DDD).
- **Stack Tecnológica:** Java 21, Manjaro Linux e Git com versionamento semântico (Conventional Commits).

## 🗺️ Roadmap de Implementação (Abordagem Bottom-Up)
Acompanhe o fluxo arquitetural de construção do projeto:

- [x] **Marco Zero:** Setup do repositório, `.gitignore` profissional e entidade base imutável (`Coordinate`).
- [ ] **Passo 1:** Interfaces e Enums do domínio (`MapFeature`, `Routable`, `RoadType`, `Category`).
- [ ] **Passo 2:** Entidades de Ponto (`Intersection`, `PointOfInterest`).
- [ ] **Passo 3:** Entidades de Conexão (`RoadSegment`).
- [ ] **Passo 4:** Agregador e Estrutura do Grafo (`RoadNetwork`).
- [ ] **Passo 5:** Motor de Roteamento (Dijkstra) e Classe `Main`.
