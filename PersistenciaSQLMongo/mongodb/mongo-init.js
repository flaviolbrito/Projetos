db = db.getSiblingDB('db_cliente');

db.cliente.insertOne({
    'cpf': '97046458057',
    'nome': 'Felipe Marques',
    'telefone': '11965790772',
    'enderecos': [
        {
            'id': '6d566b6a-9ea7-46df-8e29-1e9509732a42',
            'logradouro': 'Rua Pedro Humberto',
            'numero': '1101',
            'cep': '04533070',
            'cidade': 'São Paulo',
            'estado': 'SP'
        }
    ]
});

db.cliente.insertOne({
    'cpf': '89243633015',
    'nome': 'Deborah Miranda',
    'telefone': '11975799774',
    'enderecos': [
        {
            'id': '1936df1c-f980-4583-ad8f-86ae1ae35395',
            'logradouro': 'Rua das Perobas',
            'numero': '1205',
            'cep': '04321120',
            'cidade': 'São Paulo',
            'estado': 'SP'
        },
        {
            'id': '03667cc9-21d4-4d5c-90b1-80070c891801',
            'logradouro': 'Rua da Consolação',
            'numero': '2411',
            'cep': '01301909',
            'cidade': 'São Paulo',
            'estado': 'SP'
        }
    ]
});


db = db.getSiblingDB('db_pedido');

db.pedido.insertOne({
    'cpf': '97046458057',
    'data': ISODate('2021-12-13T03:00:00.000Z'),
    'endereco_entrega': {
        'logradouro': 'Rua Pedro Humberto',
        'numero': '1101',
        'cep': '04533070',
        'cidade': 'São Paulo',
        'estado': 'SP'
    },
    'produtos': [
        {
            'codigo': 'b01941c8-a465-40b3-95f7-6588ff53b1aa',
            'nome': 'Macbook Pro M1',
            'quantidade': 1
        }
    ]
});