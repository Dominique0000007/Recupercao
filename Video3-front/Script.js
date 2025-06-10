const API_URL = 'http://localhost:8080/usuarios'; // Ajuste para sua API
const form = document.getElementById('form-usuario');
const inputNome = document.getElementById('nome-usuario');
const lista = document.getElementById('lista-usuarios');

async function carregarUsuarios() {
lista.innerHTML = 'Carregando...';
try {
const res = await fetch(API_URL);
if (!res.ok) throw new Error('Erro ao buscar usuários');
const usuarios = await res.json();

if (usuarios.length === 0) {
lista.innerHTML = '<li>Nenhum usuário cadastrado.</li>';
return;
}

lista.innerHTML = '';
usuarios.forEach(u => {
const li = document.createElement('li');
li.textContent = `ID: ${u.id} — Usuário: ${u.usuario || 'Sem nome'}`;
lista.appendChild(li);
});
} catch (err) {
lista.innerHTML = `<li>Erro: ${err.message}</li>`;
}
}

async function adicionarUsuario(nome) {
try {
const res = await fetch(API_URL, {
method: 'POST',
headers: {'Content-Type': 'application/json'},
body: JSON.stringify({usuario: nome})
});

if (!res.ok) throw new Error('Erro ao adicionar usuário');
return await res.json();
} catch (err) {
alert(err.message);
}
}

form.addEventListener('submit', async (e) => {
e.preventDefault();
const nome = inputNome.value.trim();
if (!nome) return;

await adicionarUsuario(nome);
inputNome.value = '';
carregarUsuarios();
});

carregarUsuarios();