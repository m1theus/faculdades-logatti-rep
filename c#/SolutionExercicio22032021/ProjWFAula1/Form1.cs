using Dal;
using Model;
using System;
using System.IO;
using System.Windows.Forms;

namespace ProjWFAula1
{
    public partial class Form1 : Form
    {
        private readonly IFerramentaDB dao;
        public Form1()
        {
            InitializeComponent();
            if (dao == null)
            {
                dao = new FerramentaDB();
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            LoadGrid();
        }

        private void btnSalvar_Click(object sender, EventArgs e)
        {
            var funcionario = getFerramenta();

            if (funcionario == null)
            {
                MessageBox.Show("Campos da ferramenta invalido!");
                return;
            }

            if (dao.Insert(funcionario))
            {
                MessageBox.Show("Inserido com sucesso!");
                LoadGrid();
                clearForm();
            }
        }

        private void LoadGrid()
        {
            dGVDados.DataSource = dao.GetAll();
        }

        private Ferramenta getFerramenta()
        {
            try
            {
                return new Ferramenta
                {
                    Id = int.Parse(txtId.Text),
                    Descricao = txtDescricao.Text,
                    Tipo = txtTipo.Text,
                    Marca = txtMarca.Text,
                    Preco = double.Parse(txtPreco.Text)
                };
            }
            catch (Exception e)
            {
                return null;
            }
        }

        private void clearForm()
        {
            txtId.Text = null;
            txtDescricao.Text = null;
            txtTipo.Text = null;
            txtMarca.Text = null;
            txtPreco.Text = null;
        }

        private void btnRelatorio_Click(object sender, EventArgs e)
        {
            var txtFile = string.Format("C://Users/Administrator/Desktop/relatorios_ferramenta{0}.txt", DateTime.Now.ToString("yyyyMMdd"));
            var list = dao.GetAll();

            if (!File.Exists(txtFile))
            {
                File.Create(txtFile).Close();
                using (StreamWriter sw = File.AppendText(txtFile))
                {
                    list.ForEach(x =>
                    {
                        sw.WriteLine(string.Format("{0}|{1}|{2}|{3}|{4}", x.Id, x.Descricao, x.Tipo, x.Marca, x.Preco));
                    });

                }
            }
            else
            {
                using (StreamWriter sw = File.AppendText(txtFile))
                {
                    list.ForEach(x =>
                    {
                        sw.WriteLine(string.Format("{0}|{1}|{2}|{3}|{4}", x.Id, x.Descricao, x.Tipo, x.Marca, x.Preco));
                    });
                }
            }
        }
    }
}
