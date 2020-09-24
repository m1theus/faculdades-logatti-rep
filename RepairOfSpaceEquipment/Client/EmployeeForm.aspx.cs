using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Client
{
    public partial class EmployeeForm : System.Web.UI.Page
    {
        DBRepairSpaceEquipmentEntities context = new DBRepairSpaceEquipmentEntities();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                txtDescricao.Focus();
                loadCombo();
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
                    employee employee = context.employee.First(x => x.id == id);
                    employee.id_role = int.Parse(ddlRole.SelectedValue);
                    SendMessage("Registro alterado com sucesso.", Color.Green);
                }
                else
                {
                    employee employee = new employee()
                    {
                        name = txtDescricao.Text,
                        id_role = int.Parse(ddlRole.SelectedValue)
                    };
                    context.employee.Add(employee);
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
                var employee = context.employee.First(x => x.id == newId);
                txtId.Text = employee.id.ToString();
                txtDescricao.Text = employee.name;
            }
        }
        private void SendMessage(string message, Color color)
        {
            lblMensagem.Text = message;
            lblMensagem.ForeColor = color;
            lblMensagem.Font.Bold = true;
        }

        private void loadCombo()
        {
            ddlRole.DataSource = context.role.ToList();
            ddlRole.DataValueField = "id";
            ddlRole.DataTextField = "description";
            ddlRole.DataBind();
        }

        protected void btnVoltar_Click(object sender, EventArgs e) => Response.Redirect("Employee.aspx");
    }
}