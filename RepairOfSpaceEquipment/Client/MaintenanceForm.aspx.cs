using System;
using System.Drawing;
using System.Linq;
using System.Web.UI.WebControls;

namespace Client
{
    public partial class MaintenanceForm : System.Web.UI.Page
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
                    maintenance maintenanceResult = context.maintenance.First(x => x.id == id);
                    maintenanceResult.id_employeer = int.Parse(ddlEmployee.SelectedValue);
                    maintenanceResult.id_equipment = int.Parse(ddlEquipment.SelectedValue);
                    maintenanceResult.descricao = txtDescricao.Text;
                    SendMessage("Registro alterado com sucesso.", Color.Green);
                }
                else
                {
                    maintenance maintenance = new maintenance()
                    {
                        descricao = txtDescricao.Text,
                        id_employeer = int.Parse(ddlEmployee.SelectedValue),
                        id_equipment = int.Parse(ddlEquipment.SelectedValue)
                    };
                    context.maintenance.Add(maintenance);
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
                var maintenanceResult = context.maintenance.First(x => x.id == newId);
                txtId.Text = maintenanceResult.id.ToString();
                txtDescricao.Text = maintenanceResult.descricao;
                ddlEmployee.DataBind();
                ddlEquipment.DataBind();
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
            ddlEquipment.DataSource = context.equipment.ToList();
            ddlEquipment.DataValueField = "id";
            ddlEquipment.DataTextField = "descricao";
            ddlEquipment.DataBind();

            ddlEmployee.DataSource = context.employee.ToList();
            ddlEmployee.DataValueField = "id";
            ddlEmployee.DataTextField = "name";
            ddlEmployee.DataBind();
        }

        protected void btnVoltar_Click(object sender, EventArgs e) => Response.Redirect("Maintenance.aspx");

    }
}