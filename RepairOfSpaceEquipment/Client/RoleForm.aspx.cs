using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Client
{
    public partial class RoleForm : Page
    {
        DBRepairSpaceEquipmentEntities context = new DBRepairSpaceEquipmentEntities();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                txtDescricao.Focus();
                LoadDataPage();
            }
        }
        protected void btnSalvar_Click(object sender, EventArgs e)
        {
            try
            {
                if (!string.IsNullOrWhiteSpace(txtId.Text))
                {
                    int id = int.Parse(txtId.Text);
                    role role = context.role.First(x => x.id == id);
                    role.description = txtDescricao.Text;
                    SendMessage("Registro alterado com sucesso.", Color.Green);
                }
                else
                {
                    role role = new role()
                    {
                        description = txtDescricao.Text,
                    };
                    context.role.Add(role);
                    SendMessage("Registro criado com sucesso.", Color.Green);
                }
                context.SaveChanges();
                ResetForm(true);
            }
            catch (Exception ex)
            {
                SendMessage($"Ocorreu um erro inesperado: {ex.Message}", Color.Red);
            }

        }
        protected void btnLimpar_Click(object sender, EventArgs e)
        {
            lblMensagem.Text = String.Empty;
            ResetForm(false);
        }
        private void ResetForm(bool clearId)
        {
            if (clearId)
            {
                txtId.Text = String.Empty;
            }
            txtDescricao.Text = String.Empty;
        }

        private void LoadDataPage()
        {
            string id = Request.QueryString["id"];
            if (!String.IsNullOrEmpty(id))
            {
                int newId = Convert.ToInt32(id);
                var role = context.role.First(x => x.id == newId);
                txtId.Text = role.id.ToString();
                txtDescricao.Text = role.description;
            }
        }
        private void SendMessage(string message, Color color)
        {
            lblMensagem.Text = message;
            lblMensagem.ForeColor = color;
            lblMensagem.Font.Bold = true;
        }

        protected void btnVoltar_Click(object sender, EventArgs e) => Response.Redirect("Role.aspx");
    }
}