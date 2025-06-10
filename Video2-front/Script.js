const API_URL = 'http://localhost:8080/tarefas'; // Ajuste para sua API
const form = document.getElementById('form-tarefa');
const inputNome = document.getElementById('nome-tarefa');
const lista = document.getElementById('lista-tarefas');

// Função para buscar as tarefas e mostrar na lista
async function carregarTarefas() {
    lista.innerHTML = 'Carregando...';
    try {
    const res = await fetch(API_URL);
    if (!res.ok) throw new Error('Erro ao buscar tarefas');
    const tarefas = await res.json();

    if (tarefas.length === 0) {
        lista.innerHTML = '<li>Nenhuma tarefa cadastrada.</li>';
        return;
        }

lista.innerHTML = '';
        tarefas.forEach(tarefa => {
        const li = document.createElement('li');
        li.textContent = tarefa.nome || 'Sem nome';
        lista.appendChild(li);
        });
    } catch (err) {
        lista.innerHTML = `<li>Erro: ${err.message}</li>`;
    }
    }

// Função para enviar nova tarefa
    async function adicionarTarefa(nome) {
    try {
        const res = await fetch(API_URL, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({nome})
        });
        if (!res.ok) throw new Error('Erro ao adicionar tarefa');
        return await res.json();
    } catch (err) {
        alert(err.message);
    }
    }

    // Evento de submit do form
    form.addEventListener('submit', async (e) => {
    e.preventDefault();
    const nome = inputNome.value.trim();
    if (!nome) return;

await adicionarTarefa(nome);
inputNome.value = '';
carregarTarefas();
});

// Carregar tarefas ao abrir a página
carregarTarefas();