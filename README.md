# Recupercao

## Descrição do Projeto

O projeto **Recupercao** é uma aplicação web simples para cadastro e listagem de usuários.  
Seu objetivo principal é praticar a criação de APIs RESTful com Java Spring Boot e desenvolver um frontend básico em HTML, CSS e JavaScript que consome essa API.  
O projeto serve como base para aprender conceitos fundamentais de backend, persistência de dados e comunicação cliente-servidor.

## Tecnologias Utilizadas

- Backend: Java 17+, Spring Boot, Spring Data JPA, banco de dados H2 (embutido)
- Frontend: HTML5, CSS3, JavaScript (Fetch API)
- Ferramentas: Maven (para gerenciar dependências do backend), navegador web moderno

## Instruções de Instalação

1. Clone este repositório:
   ```bash
   git clone https://github.com/Dominique0000007/Recupercao.git
   ```

2. Acesse a pasta do backend (se disponível):
   ```bash
   cd Recupercao/backend
   ```

3. Instale as dependências e execute o projeto Spring Boot:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   > **Observação:** Caso o backend não esteja presente, você precisará criar a aplicação Spring Boot com os endpoints conforme os vídeos.

4. Abra a pasta do frontend:
   ```bash
   cd ../frontend
   ```

5. Abra o arquivo `index.html` no navegador para utilizar a interface.

## Instruções de Uso

* Com o backend rodando (geralmente em `http://localhost:8080`), o frontend fará requisições para:
  * `GET /usuarios` para listar usuários
  * `POST /usuarios` para adicionar um novo usuário via formulário

* Preencha o formulário na página para cadastrar novos usuários e veja a lista atualizada.

## Contribuições

Contribuições são bem-vindas!
Para contribuir, por favor:

* Faça um fork do projeto
* Crie uma branch para sua feature ou correção (`git checkout -b minha-feature`)
* Faça commits claros e descritivos
* Envie um pull request explicando as mudanças

## Licença

Este projeto está licenciado sob a licença MIT.
Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Outras Informações

* Caso tenha dúvidas ou precise de suporte, entre em contato comigo.
* Este projeto foi desenvolvido para fins educacionais e de prática durante o curso de desenvolvimento de sistemas.

---

Espero que este README ajude a documentar bem o seu projeto! Se você precisar de mais ajustes ou adicionar mais detalhes, é só me avisar.
